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
import com.example.coffeehouse.ui.state_holder.DessertViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.DessertAdapter;


public class DessertFragment extends Fragment {
    private DessertViewModel dessertViewModel;
    private RecyclerView recyclerView;
    private DessertAdapter dessertAdapter;
    private String TAG = "DessertFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_dessert, container,false);
        recyclerView = view.findViewById(R.id.rv_dessert);

        dessertViewModel = new ViewModelProvider(this).get(DessertViewModel.class);
        dessertAdapter = new DessertAdapter();

        recyclerView.setAdapter(dessertAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        dessertViewModel.getDessertList().observe(getViewLifecycleOwner(), snacks ->
                dessertAdapter.setDessertList(snacks));
        dessertAdapter.onItemClickListener((dessert, position) -> {
            Log.d(TAG, "Item click handle");
            Bundle bundle = new Bundle();
            bundle.putString("product_name", dessert.getName());
            bundle.putDouble("product_price", dessert.getPrice());
            bundle.putString("product_type", "Dessert");
            Log.d(TAG, dessert.getImage());
            bundle.putString("product_image", dessert.getImage());
            Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                    .navigate(R.id.action_mainFragment_to_coffeeConfigFragment, bundle);
        });
        return view;
    }
}