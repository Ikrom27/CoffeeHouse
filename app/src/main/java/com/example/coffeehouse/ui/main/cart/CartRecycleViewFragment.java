package com.example.coffeehouse.ui.main.cart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.CartAdapter;


public class CartRecycleViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private CartViewModel cartViewModel;
    private Button btnBuy;
    private TextView tvTotalPrice;
    private View view;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart_recycle_view, container, false);
        recyclerView = view.findViewById(R.id.rv_container);
        btnBuy = view.findViewById(R.id.btn_checkout);
        tvTotalPrice = view.findViewById(R.id.textView9);

        this.cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.getCartList().observe(getViewLifecycleOwner(), products -> {
            cartAdapter = new CartAdapter(products);
            recyclerView.setAdapter(cartAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        cartViewModel.getTotalPrice().observe(getViewLifecycleOwner(), total -> {
            tvTotalPrice.setText("$ " + total);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBuy.setOnClickListener(view1 -> {
            cartViewModel.getCartList().observe(getViewLifecycleOwner(), productList -> {
                if (productList != null && !productList.isEmpty()) {
                    cartViewModel.push(productList);
                }
            });
        });
    }
}