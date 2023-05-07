package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.UserLocalDataSource;
import com.example.coffeehouse.data.data_source.impl.UserLocalDataSourceImpl;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    UserLocalDataSource userLocalDataSource;

    public UserRepositoryImpl(Context context){
        userLocalDataSource = new UserLocalDataSourceImpl(context);
    }

    @Override
    public MutableLiveData<User> getUser() {
        return new MutableLiveData<>(new User());
    }

    @Override
    public MutableLiveData<User> getUser(int userID) {
        return new MutableLiveData<>(userLocalDataSource.getUser());
    }

    @Override
    public void setUser(User user) {
        userLocalDataSource.setUser(user);
    }
}
