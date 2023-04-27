package com.example.coffeehouse.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffeehouse.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_main_menu, MainFragment.class, null)
                    .commit();
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}
