package com.example.coffeehouse.data.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class Cart extends OrderItem{
    private String productName;
    private double productPrice;
    private String productType;
    private String imagePath;

    public Cart(){}
    public Cart(String name, double price,String imagePath, int quantity, int productID){
        super(quantity, productID);
        this.setProductName(name);
        this.setImagePath(imagePath);
        this.setProductPrice(price);
    }

    public void increaseOrderQuantity(){
        increaseQuantity();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
