package com.example.coffeehouse.data.repository.impl;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.orders.retrofit.RetrofitOrderDataSource;
import com.example.coffeehouse.data.data_source.products.room.RoomCartDataSource;
import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.models.OrderResponse;
import com.example.coffeehouse.data.repository.CartRepository;
import com.example.coffeehouse.data.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CartRepositoryImpl implements CartRepository {
    private RoomCartDataSource roomCartDataSource;
    private RetrofitOrderDataSource retrofitOrderDataSource;
    private String TAG = "CartRepositoryImpl";
    private OrderRepository orderRepository;

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

    @Override
    public LiveData<Double>  getTotalPrice(){
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

    public LiveData<OrderResponse> getOrderConfirm(){
        return orderRepository.getOrderConfirm();
    }
}
