package com.example.coffeehouse.ui.main.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;

public class CoffeeConfigFragment extends Fragment {
    private String TAG = "CoffeeConfigFragment";
    private CartViewModel cartViewModel;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "CoffeeConfigFragment");
        View view = inflater.inflate(R.layout.fragment_coffee_config, container, false);

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

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

        Button btToCart = view.findViewById(R.id.button);
        btToCart.setOnClickListener(view1 -> {
            assert bundle != null;
            cartViewModel.setProduct(bundle.getString("coffee_name"),
                                     "1");
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton btnBackward = view.findViewById(R.id.bt_back_light);
        btnBackward.setOnClickListener(view1 -> Navigation.findNavController(view1).navigateUp());
    }
}