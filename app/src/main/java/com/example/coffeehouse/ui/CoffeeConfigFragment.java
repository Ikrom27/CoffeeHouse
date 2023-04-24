package com.example.coffeehouse.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coffeehouse.R;

public class CoffeeConfigFragment extends Fragment {
    private String TAG = "CoffeeConfigFragment";


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "CoffeeConfigFragment");
        View view = inflater.inflate(R.layout.fragment_coffee_config, container, false);
        TextView tvTitle = view.findViewById(R.id.tv_product_title);
        TextView tvPrice = view.findViewById(R.id.tv_total_price_value);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String productName = bundle.getString("coffee_name");
            String productPrice = bundle.getString("coffee_price");
            Log.d(TAG, productName + " " + productPrice);
            tvTitle.setText(productName);
            tvPrice.setText("$" + productPrice);
        }

        ImageButton btBackward = view.findViewById(R.id.bt_back_light);
        btBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view)
                          .navigate(R.id.action_coffeeConfigFragment_to_menuFragment);
            }
        });
        return view;
    }
}