package com.example.coffeehouse.data.models;

import java.util.List;

public class OrderHistoryResponse extends OrderResponse{
    private String date;
    private boolean isReady;

    public OrderHistoryResponse(int id,
                                String date,
                                double total,
                                boolean isReady,
                                int userID,
                                List<OrderItem> orderItemList)
    {
        super(total, userID, orderItemList, id);
        this.date = date;
        this.isReady = isReady;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
