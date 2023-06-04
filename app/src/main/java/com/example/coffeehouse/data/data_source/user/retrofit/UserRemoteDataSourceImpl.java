package com.example.coffeehouse.data.data_source.user.retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.user.UserRemoteDataSource;
import com.example.coffeehouse.data.data_source.user.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.data_source.user.retrofit.UserAPI;
import com.example.coffeehouse.data.models.LoginForm;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserByID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRemoteDataSourceImpl implements UserRemoteDataSource {
    private Retrofit retrofit;
    private MutableLiveData<User> user;
    private String URL = "";
    private String TAG = "UserRemoteDataSourceImpl";

    public UserRemoteDataSourceImpl(){
        this.retrofit = RetrofitFactory.getRetrofit(URL);
        this.user = new MutableLiveData<>();
    }

    public void registerUser(User user){
        UserAPI userAPI = retrofit.create(UserAPI.class);
        userAPI.registerUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "push isSuccessful");
                }
                else {
                    Log.e(TAG, "push not Successful");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure error");
            }
        });
    }

    @Override
    public MutableLiveData<User> fetchUser(LoginForm loginForm) {
        UserAPI userAPI = retrofit.create(UserAPI.class);
        userAPI.loginUser(loginForm).enqueue(new Callback<UserByID>() {
            @Override
            public void onResponse(Call<UserByID> call, Response<UserByID> response) {
                if (response.body() == null){
                    Log.e(TAG, "response body is null!");
                }
                User test = new User();
                test.setName("Adam");
                test.setEmail("admin@mail.ru");
                test.setPhoneNumber("+79374857672");
                test.setPassword("Admin2023");
                user.setValue(test);
                if (response.isSuccessful()) {
                    //user.setValue((User) response.body());
                    Log.d(TAG, "Login successful");
                } else {
                    Log.e(TAG, "Login not successful");
                }
            }

            @Override
            public void onFailure(Call<UserByID> call, Throwable t) {
                Log.e(TAG, "onFailure error");
            }
        });

        return user;
    }
}
