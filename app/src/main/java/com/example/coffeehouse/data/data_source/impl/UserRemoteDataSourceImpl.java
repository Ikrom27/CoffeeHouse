package com.example.coffeehouse.data.data_source.impl;

import android.os.AsyncTask;

import com.example.coffeehouse.data.base.products.retrofit.RegisterUserTask;
import com.example.coffeehouse.data.data_source.UserRemoteDataSource;
import com.example.coffeehouse.data.models.User;

public class UserRemoteDataSourceImpl implements UserRemoteDataSource {

    public void pushUser(User user){
        RegisterUserTask task = new RegisterUserTask();
        task.execute(user.getName(), user.getEmail(), user.getPhone(), "", user.getPassword());
    }

    @Override
    public User fetch(User user) {
        return null;
    }
}
