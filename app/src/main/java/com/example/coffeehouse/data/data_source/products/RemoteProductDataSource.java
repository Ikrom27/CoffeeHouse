package com.example.coffeehouse.data.data_source.products;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.Product;

import java.util.List;

public interface RemoteProductDataSource {
    LiveData<List<Product>> getProductList();
}
