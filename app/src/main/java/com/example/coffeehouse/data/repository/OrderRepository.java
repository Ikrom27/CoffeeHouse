package com.example.coffeehouse.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.OrderHistoryResponse;
import com.example.coffeehouse.data.models.OrderReceive;
import com.example.coffeehouse.data.models.OrderResponse;

import java.util.List;

public interface OrderRepository {
    void pushOrder(OrderReceive orderReceive);
    void fetchOrder(int id);
    LiveData<OrderResponse> getOrderConfirm();
    void setOrderConfirm(MutableLiveData<OrderResponse> orderConfirm);
    void clearConfirmOrder();
    LiveData<List<OrderHistoryResponse>> getUserOrders(boolean isReady, int userID);
}
