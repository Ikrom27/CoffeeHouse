package com.example.coffeehouse.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        BottomNavigationView navView = view.findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(view.findViewById(R.id.fr_menu));
        NavigationUI.setupWithNavController(navView, navController);

    }
}