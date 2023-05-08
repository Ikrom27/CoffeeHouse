package com.example.coffeehouse.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        //getApplicationContext().deleteDatabase("cart_database");
    }
}
