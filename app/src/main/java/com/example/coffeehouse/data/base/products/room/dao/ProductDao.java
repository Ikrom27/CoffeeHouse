package com.example.coffeehouse.data.base.products.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product_list_table")
    LiveData<List<ProductEntity>> loadAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ProductEntity productEntity);

    @Query("SELECT * FROM product_list_table WHERE :name LIKE productName")
    LiveData<ProductEntity> getProduct(String name);

    @Delete
    void delete(ProductEntity productEntity);

    @Query("DELETE FROM product_list_table")
    void deleteAllProducts();
}
