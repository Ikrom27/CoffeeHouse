package com.example.coffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.coffeehouse.ui.state_holder.WebViewModel;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Находим контейнер
        FrameLayout container = findViewById(R.id.container);

        // Создаем экземпляр фрагмента
        BlankFragment fragment = new BlankFragment();

        // Заменяем содержимое контейнера фрагментом
        getSupportFragmentManager().beginTransaction()
                .replace(container.getId(), fragment)
                .commit();
    }
}