package com.example.coffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageButton bt_forward = findViewById(R.id.bt_wcscreen);
        bt_forward.setOnClickListener(view -> {
            Log.d(TAG, "Button click handled");
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });
    }
}