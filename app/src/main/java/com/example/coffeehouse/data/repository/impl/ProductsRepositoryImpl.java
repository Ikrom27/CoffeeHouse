package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.impl.RoomProductDataSource;
import com.example.coffeehouse.data.base.products.room.dao.ProductEntity;

import java.util.List;

public class ProductsRepositoryImpl {
    private final RoomProductDataSource roomProductDataSource;

    public ProductsRepositoryImpl(Context context){
        this.roomProductDataSource = new RoomProductDataSource(context);
    }
    public LiveData<List<ProductEntity>> getProductList(){
        return roomProductDataSource.loadAllProducts();
    }

    public LiveData<ProductEntity> getProduct(String name){
        return roomProductDataSource.getProduct(name);
    }

    public void addProduct(Product product){
        roomProductDataSource.addProduct(product);
    }
}
