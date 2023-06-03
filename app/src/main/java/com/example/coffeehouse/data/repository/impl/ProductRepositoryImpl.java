package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.coffeehouse.data.data_source.products.LocalProductDataSource;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.RemoteProductDataSource;
import com.example.coffeehouse.data.data_source.products.retrofit.RemoteProductDataSourceImpl;
import com.example.coffeehouse.data.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;


public class ProductRepositoryImpl implements ProductRepository {
    private final LocalProductDataSource localDataSource;
    private final RemoteProductDataSource remoteDataSource;
    private LiveData<List<Product>> productLiveData;

    public ProductRepositoryImpl(Context context){
        localDataSource = new com.example.coffeehouse.data.data_source.products.room.LocalProductDataSource(context);
        remoteDataSource = new RemoteProductDataSourceImpl();
        fetchProducts();
    }

    public void fetchProducts(){
        localDataSource.addProductList(remoteDataSource.getProductList());
    }

    public LiveData<Product> getCoffeeByName(String name){
        return localDataSource.getProductByName(name);
    }

    public LiveData<List<Product>> getProductList(String category){
        productLiveData = localDataSource.getProductList();
        LiveData<List<Product>> categoryLiveData = Transformations.map(productLiveData, products -> {
            List<Product> productList = new ArrayList<>();
            for (Product product : products) {
                if (product.getCategory().equalsIgnoreCase(category)){
                    productList.add(product);
                }
            }
            return productList;
        });
        return categoryLiveData;
    }
}
