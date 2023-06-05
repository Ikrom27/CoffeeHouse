package com.example.coffeehouse.data.repository;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface ProductRepository {
    void fetchProducts();
    LiveData<Product> getProductByID(int id);
    LiveData<List<Product>> getProductList(String category);
}
