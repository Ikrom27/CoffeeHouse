package com.example.coffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SignInActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent intent = result.getData();
                EditText emailView = findViewById(R.id.editTextTextEmailAddress);
                EditText passwordView = findViewById(R.id.editTextTextPassword);
                assert intent != null;
                emailView.setText(intent.getStringExtra("email"));
                passwordView.setText(intent.getStringExtra("password"));
            });

    public void onClickSignUp(View view){
        Log.d(TAG, "Button click handled");
        Intent intent = new Intent(this, SignUpActivity.class);
        mStartForResult.launch(intent);
    }

    public void onClickForward(View view){
        Log.d(TAG, "Button click handled");
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
