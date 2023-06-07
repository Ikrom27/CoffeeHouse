package com.example.coffeehouse.data.models;

import java.util.List;

public class OrderResponse extends OrderReceive{
    private int id;

    public OrderResponse(double total, int userID, List<OrderItem> orderItemList, int id) {
        super(total, userID, orderItemList);
        this.id = id;
    }

    public int getOrderID() {
        return id;
    }

    public void setOrderID(int orderID) {
        this.id = orderID;
    }
}
