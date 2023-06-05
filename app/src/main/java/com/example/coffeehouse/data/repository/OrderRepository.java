package com.example.coffeehouse.data.repository;

import com.example.coffeehouse.data.data_source.orders.retrofit.OrderReceive;
import com.example.coffeehouse.data.models.OrderItem;

import java.util.List;

public interface OrderRepository {
    void pushOrder(OrderReceive orderReceive);
    void fetchOrder(int id);
}
