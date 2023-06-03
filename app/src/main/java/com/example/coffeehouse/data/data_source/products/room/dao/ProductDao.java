package com.example.coffeehouse.data.data_source.products.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.coffeehouse.data.models.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCoffees(List<Product> productList);

    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAllCoffees();

    @Query("SELECT * FROM products WHERE name = :productName")
    LiveData<Product> getCoffeeByName(String productName);
}
