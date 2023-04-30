package com.example.coffeehouse.ui.main.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.CartAdapter;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private CartViewModel cartViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        this.cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.getProductList().observe(getViewLifecycleOwner(), productEntities -> {
            recyclerView = view.findViewById(R.id.rv_container);
            cartAdapter = new CartAdapter(productEntities);
            recyclerView.setAdapter(cartAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        });

        return view;
    }
}