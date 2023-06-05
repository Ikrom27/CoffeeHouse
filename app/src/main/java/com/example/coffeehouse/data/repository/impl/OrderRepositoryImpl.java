package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import com.example.coffeehouse.data.data_source.orders.retrofit.OrderReceive;
import com.example.coffeehouse.data.data_source.orders.retrofit.RetrofitOrderDataSource;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private RetrofitOrderDataSource retrofitOrderDataSource;

    public OrderRepositoryImpl(Context context) {
        this.retrofitOrderDataSource = new RetrofitOrderDataSource();
    }


    @Override
    public void pushOrder(OrderReceive orderReceive) {
        retrofitOrderDataSource.push(orderReceive);
    }

    @Override
    public void fetchOrder(int id) {

    }
}
