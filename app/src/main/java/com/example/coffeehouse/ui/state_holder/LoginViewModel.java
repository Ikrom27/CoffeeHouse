package com.example.coffeehouse.ui.state_holder;

import androidx.lifecycle.ViewModel;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.products.remote.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void setUser(String username, String password) {
        userRepository.saveUser(new User(username, password));
    }

    public String getEmail(){
        User user = userRepository.getUser();
        if (user != null){
            return user.getEmail();
        }
        else{
            return "";
        }
    }

    public String getPassword(){
        User user = userRepository.getUser();
        if (user != null){
            return user.getPassword();
        }
        else{
            return "";
        }
    }

}

