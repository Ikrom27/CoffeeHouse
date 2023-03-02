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
    private static final String TAG = "MyLogs";

    protected void createToast(String text){
        /*
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show(); */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        createToast("onCreate");
        Log.i(TAG, "Приложение запущено");
        Log.e(TAG, "Данные не найдены");
    }

    public void onClick(View view){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        createToast("onStart");
        Log.d(TAG, "onStart");
        Log.w(TAG, "Заканчивается память");
    }

    @Override
    protected void onResume() {
        super.onResume();
        createToast("onResume");
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        createToast("onPause");
        Log.d(TAG, "onPause");
        Log.v(TAG, "приложение было свернуто уже много раз");
    }

    @Override
    protected void onStop() {
        super.onStop();
        createToast("onStop");
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        createToast("onDestroy");
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        createToast("onRestart");
        Log.d(TAG, "onRestart");
    }
}