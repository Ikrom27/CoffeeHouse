package com.example.coffeehouse.data.base;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.data.products.list.room.dao.ProductDao;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract class ProductRoomDataBase extends RoomDatabase {

    public abstract ProductDao productDao();
    private static volatile ProductRoomDataBase INSTANCE;

    public static ProductRoomDataBase getRoomDataBase(Context context){
        if (INSTANCE == null) {
            synchronized (ProductRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProductRoomDataBase.class,
                            "cart_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
