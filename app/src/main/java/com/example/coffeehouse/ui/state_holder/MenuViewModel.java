package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;
import com.example.coffeehouse.ui.main.menu.categories.DessertFragment;
import com.example.coffeehouse.ui.main.menu.categories.CoffeeFragment;
import com.example.coffeehouse.ui.main.menu.categories.SnackFragment;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    private final List<Fragment> fragments = new ArrayList<>();
    private UserRepository userRepository;
    private CartRepositoryImpl cartRepository;

    public MenuViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepositoryImpl(application);
        cartRepository = new CartRepositoryImpl(application);

        fragments.add(new CoffeeFragment());
        fragments.add(new SnackFragment());
        fragments.add(new DessertFragment());
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepository.getCartList();
    }

    public MutableLiveData<UserResponse> getUser(){
        return userRepository.getLocalUser();
    }

    public List<Fragment> getFragments() {
        return fragments;
    }
}

