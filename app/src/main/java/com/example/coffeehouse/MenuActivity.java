package com.example.coffeehouse;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle newName = getIntent().getExtras();
        if (newName != null) {
            String profileName = newName.getString("profile_name");
            Log.d("menu", profileName);
            TextView profileNameTextView = findViewById(R.id.profile_name_textview);
            profileNameTextView.setText(profileName);
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
}
