package com.example.coffeehouse.data.products.remote.repository;

import android.content.Context;

import com.example.coffeehouse.data.data_source.UserLocalDataSourceImpl;


import com.example.coffeehouse.data.data_source.UserRemoteDataSource;
import com.example.coffeehouse.data.models.User;

public class UserRepository {
    private UserLocalDataSourceImpl userLocalDataSource;
    private UserRemoteDataSource userRemoteDataSource;
    private User user;

    public UserRepository(Context context) {
        userLocalDataSource = new UserLocalDataSourceImpl(context);
    }

    public void sync() {
    }

    public void saveUser(User user) {
        userLocalDataSource.saveUser(user);
    }

    public User getUser() {
        return userLocalDataSource.getUser();
    }
}
