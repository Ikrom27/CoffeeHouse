package com.example.coffeehouse.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.LoginForm;
import com.example.coffeehouse.data.models.User;

public interface UserRepository {

    MutableLiveData<User> getUserByEmail(LoginForm loginForm);

    void setUser(User user);
    MutableLiveData<User> getLocalUser();
    void deleteUser();
}
