package com.example.coffeehouse.data.products.list.room.dao;


import static com.example.coffeehouse.data.products.list.room.dao.ProductEntity.TABLE_NAME;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = TABLE_NAME)
public class ProductEntity {
    @NonNull
    @PrimaryKey @SerializedName("productName")
    String productName;

    @SerializedName("productPrice")
    private
    double productPrice;

    @SerializedName("productDescription")
    private
    String productDescription;
    static final String TABLE_NAME = "product_list_table";

    public ProductEntity(String productName, double productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
