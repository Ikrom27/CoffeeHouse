package com.example.coffeehouse;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onClickSignIn(View view){
        // Обработка нажатий на надпись Sign In
        Intent resultIntent = new Intent();
        EditText emailView = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordView = findViewById(R.id.editTextTextPassword);
        resultIntent.putExtra("email", emailView.getText().toString());
        resultIntent.putExtra("password", passwordView.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onClickForward(View view){
        // Обработка нажатий на кнопку
        Intent intent = new Intent(this, MenuActivity.class);
        EditText profileView = findViewById(R.id.editText_user_name);
        Log.d("SignUpActivity", profileView.getText().toString());
        intent.putExtra("profile_name", profileView.getText().toString());
        startActivity(intent);
    }
}
