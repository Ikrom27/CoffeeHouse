package com.example.coffeehouse.data.data_source.products.room;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.data_source.products.LocalProductDataSource;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.room.dao.ProductDao;

import java.util.List;

public class RoomProductDataSource implements LocalProductDataSource {
    private final ProductDao productDao;
    private final ProductRoomDataBase roomDataBase;
    private String TAG = "RoomProductDataSource";

    public RoomProductDataSource(Context context) {
        roomDataBase = ProductRoomDataBase.getInstance(context);
        this.productDao = roomDataBase.productDao();
    }

    @Override
    public void addProductList(List<Product> products){
        if (products == null){
            Log.e(TAG, "addProductList is null!");
            return;
        }
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
