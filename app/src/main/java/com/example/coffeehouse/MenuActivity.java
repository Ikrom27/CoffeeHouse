package com.example.coffeehouse;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    @Override
    protected void onStart(){
        super.onStart();
        TextView profileName = (TextView) findViewById(R.id.profile_name_textview);
        profileName.setText("Ikrom");
    }
}
