package com.example.coffeehouse.data.data_source.orders.retrofit;

import com.example.coffeehouse.data.models.OrderItem;

import java.util.List;

public class OrderReceive {
    private double total;
    private int userId;
    private List<OrderItem> orderItems;

    public OrderReceive(double total, int userID, List<OrderItem> orderItemList) {
        this.setTotal(total);
        this.setUserID(userID);
        this.setOrderItemList(orderItemList);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItems;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItems = orderItemList;
    }
}
