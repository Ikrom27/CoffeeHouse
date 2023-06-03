package com.example.coffeehouse.data.data_source.products;

import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface RemoteProductDataSource {
    List<Product> getProductList();
}
