package com.example.coffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClick(View view){
        Log.d(TAG, "Button click handled");
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
