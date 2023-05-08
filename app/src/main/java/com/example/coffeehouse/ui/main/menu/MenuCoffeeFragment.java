package com.example.coffeehouse.ui.main.menu;

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
import com.example.coffeehouse.ui.state_holder.adapter.CoffeeAdapter;
import com.example.coffeehouse.ui.state_holder.MenuCoffeeViewModel;


public class MenuCoffeeFragment extends Fragment {
    private final String TAG = "CategoriesCoffeeFragment";
    private RecyclerView recyclerView;
    private CoffeeAdapter productAdapter;
    private MenuCoffeeViewModel coffeeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_menu_coffee, container,false);
        recyclerView = view.findViewById(R.id.rv_coffee);
        this.coffeeViewModel = new ViewModelProvider(this).get(MenuCoffeeViewModel.class);

        productAdapter = new CoffeeAdapter();
        productAdapter.setCoffeeList(coffeeViewModel.getCoffeeList().getValue());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        coffeeViewModel.getCoffeeList().observe(getViewLifecycleOwner(), coffees -> {
            productAdapter.onItemClickListener((coffee, position) -> {
                Log.d(TAG, "Item click handle");
                Bundle bundle = new Bundle();
                bundle.putString("coffee_name", coffee.getName());
                bundle.putString("coffee_price", Double.toString(coffee.getPrice()));
                Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                        .navigate(R.id.action_mainFragment_to_coffeeConfigFragment, bundle);
            });

            productAdapter.setCoffeeList(coffees);
        });
        return view;
    }

}

