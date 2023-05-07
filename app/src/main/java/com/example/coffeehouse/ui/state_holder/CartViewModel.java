package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.repository.impl.ProductsRepositoryImpl;
import com.example.coffeehouse.data.base.products.room.dao.ProductEntity;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final ProductsRepositoryImpl productsRepositoryImpl;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.productsRepositoryImpl = new ProductsRepositoryImpl(application.getApplicationContext());
    }

    public void setProduct(String name, String price){
        productsRepositoryImpl.addProduct(new Product(name, Integer.parseInt(price)));
    }

    public LiveData<List<ProductEntity>> getProductList(){
        return productsRepositoryImpl.getProductList();
    }

    public void clear(){
        productsRepositoryImpl.clear();
    }
}
