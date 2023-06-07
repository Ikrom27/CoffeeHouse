package com.example.coffeehouse.data.models;

import java.util.List;

public class OrderResponse extends OrderReceive{
    private int orderID;

    public OrderResponse(double total, int userID, List<OrderItem> orderItemList, int id) {
        super(total, userID, orderItemList);
        setOrderID(id);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
