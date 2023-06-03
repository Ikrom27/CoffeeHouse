package com.example.coffeehouse.data.data_source.products.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.room.dao.ProductDao;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductRoomDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "product_database";
    private static volatile ProductRoomDataBase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductRoomDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ProductRoomDataBase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

