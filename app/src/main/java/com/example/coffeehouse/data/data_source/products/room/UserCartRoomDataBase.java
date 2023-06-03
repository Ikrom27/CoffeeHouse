package com.example.coffeehouse.data.data_source.products.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.data.data_source.products.room.dao.CartDao;
import com.example.coffeehouse.data.models.Cart;

@Database(entities = {Cart.class}, version = 1)
public abstract class UserCartRoomDataBase extends RoomDatabase {

    public abstract CartDao cartDao();
    private static volatile UserCartRoomDataBase INSTANCE;

    public static UserCartRoomDataBase getInstance(Context context){
        if (INSTANCE == null) {
            synchronized (UserCartRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserCartRoomDataBase.class,
                            "cart_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
