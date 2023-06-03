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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
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
        TextView tvDescription = view.findViewById(R.id.tv_about_text);
        ImageView imageView = view.findViewById(R.id.tv_product_image);

        Button btToCart = view.findViewById(R.id.button);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String productName = bundle.getString("product_name");
            double productPrice = bundle.getDouble("product_price");
            String productType = bundle.getString("product_type");
            String productImage = bundle.getString("product_image");
            String productDescription = bundle.getString("product_description");
            Picasso.get().load(productImage).into(imageView);
            tvTitle.setText(productName);
            tvPrice.setText("$" + productPrice);
            tvDescription.setText(productDescription);
            btToCart.setOnClickListener(view1 -> {
                cartViewModel.addToCart(productName,
                                        (float) productPrice,
                                        productType,
                                        productImage);
            });
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton btnBackward = view.findViewById(R.id.bt_back_light);
        btnBackward.setOnClickListener(view1 -> Navigation.findNavController(view1).navigateUp());
    }
}