package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

public class WelcomeViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public WelcomeViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepositoryImpl(application);
    }

    public MutableLiveData<User> getLocalUser(){
        return userRepository.getLocalUser();
    }
}
