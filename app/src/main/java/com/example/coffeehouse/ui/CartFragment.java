package com.example.coffeehouse.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.view_model.CartViewModel;
import com.example.coffeehouse.ui.view_model.CoffeeAdapter;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private CartViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.rv_container);
        return view;
    }
}