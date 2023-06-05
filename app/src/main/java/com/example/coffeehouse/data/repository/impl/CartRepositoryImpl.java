package com.example.coffeehouse.data.repository.impl;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.data_source.orders.retrofit.RetrofitOrderDataSource;
import com.example.coffeehouse.data.data_source.products.room.RoomCartDataSource;
import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImpl implements CartRepository {
    private RoomCartDataSource roomCartDataSource;
    private RetrofitOrderDataSource retrofitOrderDataSource;
    private String TAG = "CartRepositoryImpl";

    public CartRepositoryImpl(Context context){
        roomCartDataSource = new RoomCartDataSource(context);
        retrofitOrderDataSource = new RetrofitOrderDataSource();
    }

    @Override
    public LiveData<List<Cart>> getCartList(){
        return roomCartDataSource.getCartList();
    }

    @Override
    public void update(Cart cart) {
        roomCartDataSource.update(cart);
    }

    @Override
    public void addToCart(Cart cart) {
        roomCartDataSource.addCart(cart);
    }

    public void push(List<Cart> cartList){
        Log.d(TAG, cartList.size() + "");
        List<OrderItem> orderItemList = new ArrayList<>();
        for (Cart cart: cartList){
            orderItemList.add(new OrderItem(cart.getQuantity(), cart.getProductId()));
        }
        retrofitOrderDataSource.push(orderItemList);
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
