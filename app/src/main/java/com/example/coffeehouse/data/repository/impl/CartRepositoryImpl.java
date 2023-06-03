package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.data_source.products.room.RoomCartDataSource;
import com.example.coffeehouse.data.models.Cart;

import java.util.List;

public class CartRepositoryImpl {
    private RoomCartDataSource roomCartDataSource;

    public CartRepositoryImpl(Context context){
        roomCartDataSource = new RoomCartDataSource(context);
    }

    public LiveData<List<Cart>> getCartList(){
        return roomCartDataSource.getCartList();
    }

    public void addToCart(Cart cart) {
        roomCartDataSource.addCart(cart);
    }

    public LiveData<Integer>  getTotalPrice(){
        return roomCartDataSource.getTotalPrice();
    }

    public void clear(){
        roomCartDataSource.clear();
    }
}
