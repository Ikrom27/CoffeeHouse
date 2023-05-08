package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.models.Snack;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final CartRepositoryImpl cartRepositoryImpl;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.cartRepositoryImpl = new CartRepositoryImpl(application.getApplicationContext());
    }

    public void addToCart(String name, float price, String type){
        cartRepositoryImpl.addToCart(new Cart(name, price, type));
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepositoryImpl.getCartList();
    }

    public void clear(){
        cartRepositoryImpl.clear();
    }
}
