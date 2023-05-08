package com.example.coffeehouse.data.base.products.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.models.Snack;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCoffees(List<Coffee> productList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllSnacks(List<Snack> productList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDesserts(List<Dessert> productList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllProducts(List<Product> productList);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM coffees")
    LiveData<List<Coffee>> getAllCoffees();


    @Query("SELECT * FROM snacks")
    LiveData<List<Snack>> getAllSnacks();

    @Query("SELECT * FROM desserts")
    LiveData<List<Dessert>> getAllDesserts();

    @Query("SELECT * FROM products WHERE name = :productName")
    LiveData<Product> getProductByName(String productName);

    @Query("SELECT * FROM coffees WHERE name = :productName")
    LiveData<Coffee> getCoffeeByName(String productName);

    @Query("SELECT * FROM snacks WHERE name = :productName")
    LiveData<Snack> getSnackByName(String productName);

    @Query("SELECT * FROM desserts WHERE name = :productName")
    LiveData<Dessert> getDessertByName(String productName);

}
