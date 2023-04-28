package com.example.coffeehouse.data.products.list;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public interface ProductLocalDataSource {
    LiveData<List<ProductEntity>> loadAllProducts();
}
