package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

public class ProfileViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepositoryImpl(application);
    }

    public MutableLiveData<UserResponse> getUser(){
        return userRepository.getLocalUser();
    }

    public void exitUser(){
        userRepository.deleteUser();
    }
}
