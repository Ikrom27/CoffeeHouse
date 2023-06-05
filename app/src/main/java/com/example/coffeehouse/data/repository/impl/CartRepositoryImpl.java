package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.data_source.products.room.RoomCartDataSource;
import com.example.coffeehouse.data.models.Cart;

import java.util.List;

public class CartRepositoryImpl implements CartRepository {
    private RoomCartDataSource roomCartDataSource;

    public CartRepositoryImpl(Context context){
        roomCartDataSource = new RoomCartDataSource(context);
    }

    @Override
    public LiveData<List<Cart>> getCartList(){
        return roomCartDataSource.getCartList();
    }

    @Override
    public void addToCart(Cart cart) {
        roomCartDataSource.addCart(cart);
    }

    @Override
    public LiveData<Integer>  getTotalPrice(){
        return roomCartDataSource.getTotalPrice();
    }

    @Override
    public LiveData<Cart> getOrderByID(int id) {
        return roomCartDataSource.getOrderByID(id);
    }

    @Override
    public void clear(){
        roomCartDataSource.clear();
    }
}
