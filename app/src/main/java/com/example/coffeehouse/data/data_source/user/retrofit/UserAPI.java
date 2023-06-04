package com.example.coffeehouse.data.data_source.user.retrofit;

import com.example.coffeehouse.data.models.LoginForm;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserByID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/api/v1/users/register")
    Call<User> registerUser(@Body User user);

    @POST("/api/v1/users/auth")
    Call<UserByID> loginUser(@Body LoginForm form);
}
