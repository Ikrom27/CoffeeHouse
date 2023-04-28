package com.example.coffeehouse.data.products.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.products.list.room.RoomProductDataSource;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public class ProductsRepository {
    private RoomProductDataSource roomProductDataSource;

    public LiveData<List<ProductEntity>> getProductList(){
        MutableLiveData<List<ProductEntity>> productList = new MutableLiveData<>();
        productList.setValue(roomProductDataSource.loadAllProducts());
        return productList;
    }

    public void addProduct(Product product){
        roomProductDataSource.addProduct(product);
    }
}
