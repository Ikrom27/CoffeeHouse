package com.example.coffeehouse.data.repository.impl;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface CartRepository {
    LiveData<List<Cart>> getCartList();
    void addToCart(Cart cart);
    LiveData<Integer> getTotalPrice();
    LiveData<Cart> getOrderByID(int id);
    void clear();
}
