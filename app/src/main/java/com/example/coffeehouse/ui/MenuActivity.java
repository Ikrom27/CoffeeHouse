package com.example.coffeehouse.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.coffeehouse.R;

import com.example.coffeehouse.databinding.ActivityMenuBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,
                R.id.fragment_main_menu);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}
