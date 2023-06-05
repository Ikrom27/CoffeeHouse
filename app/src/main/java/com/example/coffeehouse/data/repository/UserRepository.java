package com.example.coffeehouse.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;

public interface UserRepository {

    MutableLiveData<UserResponse> loginByEmail(UserRequest userRequest);

    void registerUser(User user);
    MutableLiveData<UserResponse> getLocalUser();
    void deleteUser();
}
