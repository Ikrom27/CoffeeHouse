package com.example.coffeehouse.data.data_source.user.retrofit;

import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/api/v1/users/register")
    Call<Integer> registerUser(@Body User user);

    @POST("/api/v1/users/auth")
    Call<UserResponse> loginUser(@Body UserRequest form);
}
