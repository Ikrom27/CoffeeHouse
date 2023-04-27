package com.example.coffeehouse;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.coffeehouse.ui.MainActivity;

public class OrderStatusService extends Service {
    public OrderStatusService() {
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCreate() {
        super.onCreate();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        TextView timer = new TextView(this);
        Button btn = new Button(this);
        btn.setBackgroundColor(Color.WHITE);
        new CountDownTimer(200000, 1000) {

            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                timer.setText("Ваш заказ будет готов через: " + String.valueOf(l / 1000));
                btn.setText(timer.getText());
            }

            @Override
            public void onFinish() {
                timer.setText("Ваш заказ готов!");
                btn.setText(timer.getText());
            }
        }.start();
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            stopSelf();
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
            params.gravity = Gravity.TOP | Gravity.START;
            windowManager.addView(btn, params);
            windowManager.updateViewLayout(btn, params);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}