package com.example.coffeehouse.data.data_source;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.base.products.room.dao.ProductEntity;

import java.util.List;

public interface ProductLocalDataSource {
    LiveData<List<ProductEntity>> loadAllProducts();
}
