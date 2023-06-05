package com.example.coffeehouse.data.models;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class OrderItem {
    private int quantity;
    @PrimaryKey
    @NonNull
    private int productId;

    public OrderItem(int quantity, int productId) {
        this.setQuantity(quantity);
        this.setProductId(productId);
    }
    OrderItem(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void increaseQuantity(){
        this.quantity += 1;
    }
}
