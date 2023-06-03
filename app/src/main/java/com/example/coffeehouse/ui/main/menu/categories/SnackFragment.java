package com.example.coffeehouse.ui.main.menu.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CategoryViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.ProductAdapter;


public class SnackFragment extends Fragment {
    private String TAG = "SnackFragment";

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private CategoryViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_menu_coffee, container,false);
        recyclerView = view.findViewById(R.id.rv_coffee);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        productAdapter = new ProductAdapter();
        recyclerView.setAdapter(productAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        categoryViewModel.getProductList("snack").observe(getViewLifecycleOwner(), coffees -> {
            productAdapter.setProductList(coffees);
        });
        productAdapter.onItemClickListener((coffee, position) -> {
            Log.d(TAG, "Item click handle");
            Bundle bundle = new Bundle();
            bundle.putString("product_name", coffee.getName());
            bundle.putDouble("product_price", coffee.getPrice());
            bundle.putString("product_type", "Coffee");
            bundle.putString("product_image", coffee.getImgUrl());
            Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                    .navigate(R.id.action_mainFragment_to_coffeeConfigFragment, bundle);
        });
        return view;
    }

}