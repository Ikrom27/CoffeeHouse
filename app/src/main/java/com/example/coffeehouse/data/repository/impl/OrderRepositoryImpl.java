package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.coffeehouse.data.models.OrderHistoryResponse;
import com.example.coffeehouse.data.models.OrderReceive;
import com.example.coffeehouse.data.data_source.orders.retrofit.RetrofitOrderDataSource;
import com.example.coffeehouse.data.models.OrderResponse;
import com.example.coffeehouse.data.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private RetrofitOrderDataSource retrofitOrderDataSource;
    private MutableLiveData<OrderResponse> orderConfirm = new MutableLiveData<>();
    private LiveData<List<OrderHistoryResponse>> categoryLiveData = new MutableLiveData<>();
    private String TAG = "OrderRepositoryImpl";

    public OrderRepositoryImpl(Context context) {
        this.setRetrofitOrderDataSource(new RetrofitOrderDataSource());
    }


    @Override
    public void pushOrder(OrderReceive orderReceive) {
        getRetrofitOrderDataSource().push(orderReceive).observeForever(id -> {
           if (id != null){
               orderConfirm.postValue(new OrderResponse(orderReceive.getTotal(),
                       orderReceive.getUserID(),
                       orderReceive.getOrderItemList(),
                       id));
           }
        });
    }

    @Override
    public void fetchOrder(int id) {

    }

    public RetrofitOrderDataSource getRetrofitOrderDataSource() {
        return retrofitOrderDataSource;
    }


    public void setRetrofitOrderDataSource(RetrofitOrderDataSource retrofitOrderDataSource) {
        this.retrofitOrderDataSource = retrofitOrderDataSource;
    }

    @Override
    public LiveData<OrderResponse> getOrderConfirm() {
        return orderConfirm;
    }

    @Override
    public void setOrderConfirm(MutableLiveData<OrderResponse> orderConfirm) {
        this.orderConfirm = orderConfirm;
    }

    @Override
    public void clearConfirmOrder() {
        orderConfirm.setValue(null);
    }

    @Override
    public LiveData<List<OrderHistoryResponse>> getUserOrders(boolean isReady,int userID) {

        LiveData<List<OrderHistoryResponse>> orderHistory = retrofitOrderDataSource.getOrderHistory(userID);
        categoryLiveData = Transformations.map(orderHistory, orders -> {
            List<OrderHistoryResponse> orderList = new ArrayList<>();
            for (OrderHistoryResponse order : orders) {
                if (order.isReady() == isReady){
                    orderList.add(order);
                }
            }
            return orderList;
        });
        return categoryLiveData;
    }
}
