package com.example.coffeehouse.data.data_source.user.retrofit;

import com.example.coffeehouse.data.models.LoginForm;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserByID;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/api/users/auth/register")
    Call<User> registerUser(@Body User user);

    @POST("/api/users/auth/login")
    Call<UserByID> loginUser(@Body LoginForm form);
}