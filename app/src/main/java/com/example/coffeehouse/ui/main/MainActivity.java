package com.example.coffeehouse.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.coffeehouse.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),
                "Server not fount. Offline mod",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        //getApplicationContext().deleteDatabase("cart_database");
        //getApplicationContext().deleteDatabase("product_database");
    }
}
