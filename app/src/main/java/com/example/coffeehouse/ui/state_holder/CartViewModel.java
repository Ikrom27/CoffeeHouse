package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.products.remote.repository.ProductsRepository;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final ProductsRepository productsRepository;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.productsRepository = new ProductsRepository(application.getApplicationContext());
    }

    public void setProduct(String name, String price){
        productsRepository.addProduct(new Product(name, Integer.parseInt(price)));
    }

    public LiveData<List<ProductEntity>> getProductList(){
        return productsRepository.getProductList();
    }
}
