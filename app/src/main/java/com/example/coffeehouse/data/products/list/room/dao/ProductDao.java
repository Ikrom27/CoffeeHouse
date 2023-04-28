package com.example.coffeehouse.data.products.list.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product_list_table")
    List<ProductEntity> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ProductEntity productEntity);

    @Query("SELECT * FROM product_list_table WHERE :name LIKE productName")
    List<ProductEntity> getProduct(String name);

    @Delete
    void delete(ProductEntity productEntity);
}
