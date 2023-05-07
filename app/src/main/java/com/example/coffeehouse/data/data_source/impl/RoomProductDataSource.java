package com.example.coffeehouse.data.data_source.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.base.products.room.ProductRoomDataBase;
import com.example.coffeehouse.data.data_source.ProductLocalDataSource;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.base.products.room.dao.ProductDao;
import com.example.coffeehouse.data.base.products.room.dao.ProductEntity;

import java.util.List;

public class RoomProductDataSource implements ProductLocalDataSource {
    private final ProductDao productDao;
    private final ProductRoomDataBase productRoomDataBase;

    public RoomProductDataSource(Context context) {
        this.productRoomDataBase = ProductRoomDataBase.getRoomDataBase(context);
        this.productDao = productRoomDataBase.productDao();
    }

    @Override
    public LiveData<List<ProductEntity>> loadAllProducts() {
        return productDao.loadAllProducts();
    }

    public void addProduct(Product product){
        productRoomDataBase.getQueryExecutor().execute(() -> {
            ProductEntity entity = new ProductEntity(product.getName(), product.getPrice());
            productDao.insert(entity);
        });
    }

    public LiveData<ProductEntity> getProduct(String name){
        return productDao.getProduct(name);
    }

    public void deleteAllProducts(){
        productRoomDataBase.getQueryExecutor().execute(productDao::deleteAllProducts);
    }
}
