package com.example.coffeehouse.data.products.list;

import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface ProductRemoteDataSource {
    List<Product> getProductList();
}
