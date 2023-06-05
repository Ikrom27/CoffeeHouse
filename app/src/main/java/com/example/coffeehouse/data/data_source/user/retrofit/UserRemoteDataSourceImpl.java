package com.example.coffeehouse.data.data_source.user.retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.user.UserRemoteDataSource;
import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRemoteDataSourceImpl implements UserRemoteDataSource {
    private Retrofit retrofit;
    private String URL = "";
    private String TAG = "UserRemoteDataSourceImpl";

    public UserRemoteDataSourceImpl(){
        this.retrofit = RetrofitFactory.getRetrofit(URL);
    }

    public MutableLiveData<Integer> setUser(User user){
        MutableLiveData<Integer> userID = new MutableLiveData<>();
        UserAPI userAPI = retrofit.create(UserAPI.class);
        userAPI.registerUser(user).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "User id get successful " + response.body());
                    userID.setValue(response.body());
                }
                else{
                    Log.e(TAG, "User id get error");
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(TAG, "onResponse error");
            }
        });
        return userID;
    }

    @Override
    public MutableLiveData<UserResponse> getUser(UserRequest userRequest) {
        MutableLiveData<UserResponse> userResponse = new MutableLiveData<>();
        UserAPI userAPI = retrofit.create(UserAPI.class);
        userAPI.loginUser(userRequest).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    userResponse.setValue(response.body());
                    Log.d(TAG, "User response is successful");
                }
                else{
                    Log.e(TAG, "User response is not successful");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e(TAG, "onFailure error");
            }
        });
        return userResponse;
    }
}
