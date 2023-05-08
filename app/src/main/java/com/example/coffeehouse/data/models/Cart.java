package com.example.coffeehouse.data.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class Cart {
    @PrimaryKey (autoGenerate = true)
    private int cartId;
    private String productName;
    private float productPrice;
    private String productType;

    public Cart(){
        
    }

    public Cart(String name, float price,String type){
        this.setProductName(name);
        this.setProductType(type);
        this.setProductPrice(price);
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
