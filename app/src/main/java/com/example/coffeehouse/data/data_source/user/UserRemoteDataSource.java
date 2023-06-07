package com.example.coffeehouse.data.data_source.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;

public interface UserRemoteDataSource {

    MutableLiveData<Integer> setUser(User user);
    MutableLiveData<UserResponse> getUser(UserRequest userRequest);
    MutableLiveData<Integer> getRequestState();
}
