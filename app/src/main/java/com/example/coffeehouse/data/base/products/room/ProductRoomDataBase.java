package com.example.coffeehouse.data.base.products.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.base.products.room.dao.ProductDao;
import com.example.coffeehouse.data.models.Snack;

@Database(entities = {Product.class, Coffee.class, Snack.class, Dessert.class}, version = 2)
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

