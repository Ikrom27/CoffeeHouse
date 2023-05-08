package com.example.coffeehouse.data.data_source.impl;

import android.content.Context;

import androidx.lifecycle.LiveData;
import com.example.coffeehouse.data.base.products.room.UserCartRoomDataBase;
import com.example.coffeehouse.data.base.products.room.dao.CartDao;
import com.example.coffeehouse.data.models.Cart;
import java.util.List;

public class RoomCartDataSource {
    private final UserCartRoomDataBase userCartRoomDataBase;
    private final CartDao cartDao;

    public RoomCartDataSource(Context context){
        userCartRoomDataBase = UserCartRoomDataBase.getInstance(context);
        cartDao = userCartRoomDataBase.cartDao();
    }

    public void addCart(Cart cart){
        userCartRoomDataBase.getQueryExecutor().execute(()-> cartDao.insertCart(cart));
    }

    public LiveData<List<Cart>> getCartList(){
        return cartDao.getCartList();
    }

    public int getTotalPrice(){
        return cartDao.getTotalPrice();
    }

    public void clear(){
        userCartRoomDataBase.getQueryExecutor().execute(cartDao::clearCart);
    }
}