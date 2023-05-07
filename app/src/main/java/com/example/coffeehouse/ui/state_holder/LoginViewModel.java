package com.example.coffeehouse.ui.state_holder;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.Objects;

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

    public boolean toLogin(){
        MutableLiveData<User> user = userRepository.getUserByEmail(userEmail);
        if (user == null){
            Log.d(TAG, "Wrong email");
            return false;
        }
        else{
            Log.d(TAG, "real password^ " + Objects.requireNonNull(user.getValue()).getPassword());
            return Objects.equals(user.getValue().getPassword(), userPassword);
        }
    }
}

