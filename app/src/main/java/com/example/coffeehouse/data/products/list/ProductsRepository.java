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

    public ProductsRepository(Context context){
        ProductRoomDataBase db = ProductRoomDataBase.getRoomDataBase(context);
        roomProductDataSource = new RoomProductDataSource(db.productDao());
    }
    public LiveData<List<ProductEntity>> getProductList(){
        return roomProductDataSource.loadAllProducts();
    }

    public void addProduct(Product product){
        roomProductDataSource.addProduct(product);
    }
}
