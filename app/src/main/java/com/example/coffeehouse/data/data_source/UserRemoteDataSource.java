package com.example.coffeehouse.data.data_source;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.LoginForm;
import com.example.coffeehouse.data.models.User;

public interface UserRemoteDataSource {

    void registerUser(User user);
    MutableLiveData<User> fetchUser(LoginForm loginForm);
}
