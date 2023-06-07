package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.UserRequest;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

public class LoginViewModel extends AndroidViewModel {
    private String TAG = "LoginViewModel";
    private UserRepository userRepository;
    private String userEmail;
    private String userPassword;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepositoryImpl(application);
    }

    public void setEmail(String email){
        userEmail = email;
    }

    public void setPassword(String password){
        userPassword = password;
    }

    public MutableLiveData<UserResponse> getUserByEmail(){
        UserRequest userRequest = new UserRequest(userEmail, userPassword);
        return userRepository.loginByEmail(userRequest);
    }

    public MutableLiveData<Integer> getRequestState(){
        return userRepository.getRequestState();
    }
}

