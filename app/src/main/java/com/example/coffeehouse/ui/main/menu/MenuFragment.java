package com.example.coffeehouse.ui.main.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.coffeehouse.R;

public class MenuFragment extends Fragment {
    private final String TAG = "CategoriesFragment";
    private final Fragment coffeeFragment = new MenuCoffeeFragment();

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        ImageButton cartButton = view.findViewById(R.id.bt_buy_light);
        cartButton.setOnClickListener(view1 -> Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                .navigate(R.id.action_mainFragment_to_cartFragment));
        return view;
    }
}