package com.example.coffeehouse.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.User;

public interface UserRepository {
    MutableLiveData<User> getUser(int userID);
    MutableLiveData<User> getUser();
    void setUser(User user);
}
