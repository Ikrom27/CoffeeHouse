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
    int productPrice;

    @SerializedName("productDescription")
    private
    String productDescription;
    static final String TABLE_NAME = "product_list_table";

    public ProductEntity(String productName, int productPrice){
        this.productName = productName;
        this.setProductPrice(productPrice);
    }

    public int getProductPrice() {
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
