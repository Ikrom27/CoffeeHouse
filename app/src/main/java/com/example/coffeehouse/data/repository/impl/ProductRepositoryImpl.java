package com.example.coffeehouse.data.repository.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Snack;
import com.example.coffeehouse.data.data_source.RetrofitProductDataSource;
import com.example.coffeehouse.data.data_source.impl.RetrofitProductDataSourceImpl;
import com.example.coffeehouse.data.data_source.impl.RoomProductDataSource;
import com.example.coffeehouse.data.repository.ProductRepository;

import java.util.List;


public class ProductRepositoryImpl implements ProductRepository {
    private final RoomProductDataSource localDataSource;
    private final RetrofitProductDataSource remoteDataSource;

    public ProductRepositoryImpl(Context context){
        localDataSource = new RoomProductDataSource(context);
        remoteDataSource = new RetrofitProductDataSourceImpl();
        refreshData();
    }

    public void refreshData(){
        localDataSource.addCoffeeList(remoteDataSource.getCoffees());
        localDataSource.addSnackList(remoteDataSource.getSnacks());
        localDataSource.addDesseretList(remoteDataSource.getDesserts());
    }

    public LiveData<List<Coffee>> getCoffeeList(){
        return localDataSource.getCoffees();
    }

    public LiveData<List<Snack>> getSnackList(){
        return localDataSource.getSnacks();
    }

    public LiveData<List<Dessert>> getDessertList(){
        return localDataSource.getDesserts();
    }
}
