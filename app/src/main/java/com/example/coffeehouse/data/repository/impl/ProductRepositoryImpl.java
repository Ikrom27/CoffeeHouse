package com.example.coffeehouse.data.repository.impl;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.coffeehouse.data.data_source.products.LocalProductDataSource;
import com.example.coffeehouse.data.data_source.products.room.RoomProductDataSource;
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
    private final String TAG = "ProductRepositoryImpl";

    public ProductRepositoryImpl(Context context){
        localDataSource = new RoomProductDataSource(context);
        remoteDataSource = new RemoteProductDataSourceImpl();
        fetchProducts();
    }

    public void fetchProducts(){
        LiveData<List<Product>> products = remoteDataSource.getProductList();
        products.observeForever(localDataSource::addProductList);
    }

    @Override
    public LiveData<Product> getProductByID(int id) {
        return localDataSource.getProductByID(id);
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
