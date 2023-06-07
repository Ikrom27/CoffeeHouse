package com.example.coffeehouse.data.repository.impl;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.user.UserLocalDataSource;
import com.example.coffeehouse.data.data_source.user.UserRemoteDataSource;
import com.example.coffeehouse.data.data_source.user.UserLocalDataSourceImpl;
import com.example.coffeehouse.data.data_source.user.retrofit.UserRemoteDataSourceImpl;
import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;
import com.example.coffeehouse.data.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;
    private final String TAG = "UserRepositoryImpl";

    public UserRepositoryImpl(Context context){
        userLocalDataSource = new UserLocalDataSourceImpl(context);
        userRemoteDataSource = new UserRemoteDataSourceImpl();
    }

    @Override
    public MutableLiveData<UserResponse> loginByEmail(UserRequest userRequest) {
        MutableLiveData<UserResponse> user = userRemoteDataSource.getUser(userRequest);
        user.observeForever(remoteUser -> {
            userLocalDataSource.setUser(user.getValue());
            if (user.getValue() == null) {
                Log.e(TAG, "Remote user is null");
            }
        });
        return user;
    }

    @Override
    public void registerUser(User user) {
        MutableLiveData<Integer> userID = userRemoteDataSource.setUser(user);
        userID.observeForever(id -> {
            UserResponse userResponse = new UserResponse(id, user);
            userResponse.setId(id);
            userLocalDataSource.setUser(userResponse);
        });
    }

    @Override
    public MutableLiveData<UserResponse> getLocalUser() {
        return new MutableLiveData<>(userLocalDataSource.getUser());
    }

    @Override
    public int getUserId() {
        return userLocalDataSource.getUser().getId();
    }

    @Override
    public void deleteUser(){
        userLocalDataSource.deleteUser();
    }

    @Override
    public MutableLiveData<Integer> getRequestState() {
        return userRemoteDataSource.getRequestState();
    }
}
