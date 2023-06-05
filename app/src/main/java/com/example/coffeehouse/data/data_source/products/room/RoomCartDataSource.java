package com.example.coffeehouse.data.data_source.products.room;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.products.room.UserCartRoomDataBase;
import com.example.coffeehouse.data.data_source.products.room.dao.CartDao;
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

    public LiveData<Cart> getOrderByID(int id){
        return cartDao.getOrderById(id);
    }

    public LiveData<List<Cart>> getCartList(){
        return cartDao.getCartList();
    }

    public MutableLiveData<Integer>  getTotalPrice(){
        MutableLiveData<Integer> totalPrice = new MutableLiveData<>(0);
        userCartRoomDataBase.getQueryExecutor().execute(()-> {
            totalPrice.postValue(cartDao.getTotalPrice());
        });
        return totalPrice;
    }

    public void clear(){
        userCartRoomDataBase.getQueryExecutor().execute(cartDao::clearCart);
    }
}
