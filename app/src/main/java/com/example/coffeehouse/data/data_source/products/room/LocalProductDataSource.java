package com.example.coffeehouse.data.data_source.products.room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.room.dao.ProductDao;

import java.util.List;

public class LocalProductDataSource implements com.example.coffeehouse.data.data_source.products.LocalProductDataSource {
    private final ProductDao productDao;
    private final ProductRoomDataBase roomDataBase;

    public LocalProductDataSource(Context context) {
        roomDataBase = ProductRoomDataBase.getInstance(context);
        this.productDao = roomDataBase.productDao();
    }

    @Override
    public void addProductList(List<Product> products){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.insertAllCoffees(products);
        });
    }

    @Override
    public LiveData<Product> getProductByName(String name){
        return productDao.getCoffeeByName(name);
    }

    @Override
    public LiveData<List<Product>> getProductList(){
        return productDao.getAllCoffees();
    }
}
