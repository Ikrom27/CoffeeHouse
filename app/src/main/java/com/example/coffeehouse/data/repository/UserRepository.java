package com.example.coffeehouse.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.coffeehouse.data.data_source.UserDataSource;
import com.google.gson.Gson;


import com.example.coffeehouse.data.models.User;

public class UserRepository {
    private UserDataSource userDataSource;

    public UserRepository(Context context) {
        userDataSource = new UserDataSource(context);
    }

    public void saveUser(User user) {
        //WRITE
        userDataSource.saveUser(user);
    }

    public User getUser() {
        //READ
        return userDataSource.getUser();
    }
}
