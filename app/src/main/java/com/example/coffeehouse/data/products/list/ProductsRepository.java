package com.example.coffeehouse.data.products.list;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.base.ProductRoomDataBase;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.products.list.room.RoomProductDataSource;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public class ProductsRepository {
    private RoomProductDataSource roomProductDataSource;
    private ProductRoomDataBase dataBase;

    public ProductsRepository(Context context){
        this.dataBase = ProductRoomDataBase.getRoomDataBase(context);
        roomProductDataSource = new RoomProductDataSource(dataBase.productDao());
    }
    public LiveData<List<ProductEntity>> getProductList(){
        return roomProductDataSource.loadAllProducts();
    }

    public LiveData<ProductEntity> getProduct(String name){
        return roomProductDataSource.getProduct(name);
    }

    public void addProduct(Product product){
        dataBase.getQueryExecutor().execute(() -> {
            roomProductDataSource.addProduct(product);
        });
    }
}
