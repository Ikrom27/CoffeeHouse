package com.example.coffeehouse.data.data_source.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.base.products.room.ProductRoomDataBase;
import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.base.products.room.dao.ProductDao;
import com.example.coffeehouse.data.models.Snack;

import java.util.List;

public class RoomProductDataSource {
    private final ProductDao productDao;
    private final ProductRoomDataBase roomDataBase;

    public RoomProductDataSource(Context context) {
        roomDataBase = ProductRoomDataBase.getInstance(context);
        this.productDao = roomDataBase.productDao();
    }

    public void addProduct(Product product){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.insertProduct(product);
        });
    }

    public void updateProduct(Product product){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.updateProduct(product);
        });
    }

    public void deleteProduct(Product product){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.updateProduct(product);
        });
    }

    public void addCoffeeList(List<Coffee> coffees){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.insertAllCoffees(coffees);
        });
    }

    public void addSnackList(List<Snack>  snacks){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.insertAllSnacks(snacks);
        });
    }

    public void addDessertList(List<Dessert>  desserts){
        roomDataBase.getQueryExecutor().execute(() -> {
            productDao.insertAllDesserts(desserts);
        });
    }

    public LiveData<Coffee> getCoffeeByName(String name){
        return productDao.getCoffeeByName(name);
    }

    public LiveData<Snack> getSnackByName(String name){
        return productDao.getSnackByName(name);
    }

    public LiveData<Dessert> getDessertByName(String name){
        return productDao.getDessertByName(name);
    }

    public LiveData<List<Coffee>> getCoffees(){
        return productDao.getAllCoffees();
    }

    public LiveData<List<Snack>> getSnacks(){
        return productDao.getAllSnacks();
    }

    public LiveData<List<Dessert>> getDesserts(){
        return productDao.getAllDesserts();
    }
}
