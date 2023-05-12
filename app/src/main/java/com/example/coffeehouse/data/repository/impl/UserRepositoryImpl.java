package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.UserLocalDataSource;
import com.example.coffeehouse.data.data_source.UserRemoteDataSource;
import com.example.coffeehouse.data.data_source.impl.UserLocalDataSourceImpl;
import com.example.coffeehouse.data.data_source.impl.UserRemoteDataSourceImpl;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.repository.UserRepository;

import java.util.Objects;
import java.util.concurrent.Executors;

public class UserRepositoryImpl implements UserRepository {
    private UserLocalDataSource userLocalDataSource;
    private UserRemoteDataSource userRemoteDataSource;

    public UserRepositoryImpl(Context context){
        userLocalDataSource = new UserLocalDataSourceImpl(context);
        userRemoteDataSource = new UserRemoteDataSourceImpl();
    }

    @Override
    public MutableLiveData<User> getUserByEmail(String userEmail) {
        MutableLiveData<User> user = new MutableLiveData<>(userLocalDataSource.getUser());
        if (user.getValue() != null && Objects.equals(user.getValue().getEmail(), userEmail)){
            return new MutableLiveData<>(userLocalDataSource.getUser());
        }
        return null;
    }

    @Override
    public void setUser(User user) {
        Executors.newSingleThreadExecutor().execute(() -> userLocalDataSource.setUser(user));
        userRemoteDataSource.pushUser(user);
    }

    @Override
    public MutableLiveData<User> getLocalUser() {
        return new MutableLiveData<>(userLocalDataSource.getUser());
    }

    public void deleteUser(){
        userLocalDataSource.deleteUser();
    }
}
