package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final CartRepositoryImpl cartRepositoryImpl;
    private final ProductRepositoryImpl productRepository;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.cartRepositoryImpl = new CartRepositoryImpl(application.getApplicationContext());
        this.productRepository = new ProductRepositoryImpl(application.getApplicationContext());
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepositoryImpl.getCartList();
    }

    public LiveData<Integer> getTotalPrice(){
        return cartRepositoryImpl.getTotalPrice();
    }
    public void push(List<Cart> cartList){
        cartRepositoryImpl.push(cartList);
    }

    public void clear(){
        cartRepositoryImpl.clear();
    }
}
