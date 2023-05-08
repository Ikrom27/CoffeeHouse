package com.example.coffeehouse.data.base.products.room.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.coffeehouse.data.models.Cart;

import java.util.List;


@Dao
public interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCart(Cart cart);

    @Query("SELECT * FROM cart")
    LiveData<List<Cart>> getCartList();

    @Query("SELECT * FROM cart WHERE cartId = :cartId")
    LiveData<Cart> getCartById(int cartId);

    @Query("SELECT SUM(productPrice) FROM cart;")
    int getTotalPrice();

    @Query("DELETE FROM cart WHERE cartId = :id")
    void deleteCartById(int id);

    @Query("DELETE FROM cart")
    void clearCart();
}
