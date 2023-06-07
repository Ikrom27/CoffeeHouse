package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.OrderReceive;
import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.models.OrderResponse;
import com.example.coffeehouse.data.repository.OrderRepository;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.OrderRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CartViewModel extends AndroidViewModel {
    private final CartRepositoryImpl cartRepositoryImpl;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.cartRepositoryImpl = new CartRepositoryImpl(application.getApplicationContext());
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepositoryImpl.getCartList();
    }

    public LiveData<Double> getTotalPrice(){
        return cartRepositoryImpl.getTotalPrice();
    }

    public void clear(){
        cartRepositoryImpl.clear();
    }
}
