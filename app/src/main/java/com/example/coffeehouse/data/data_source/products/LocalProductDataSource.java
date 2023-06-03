package com.example.coffeehouse.data.data_source.products;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface LocalProductDataSource {
    void addProductList(List<Product> products);

    LiveData<Product> getProductByName(String name);

    LiveData<List<Product>> getProductList();
}
