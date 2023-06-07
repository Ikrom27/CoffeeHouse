package com.example.coffeehouse.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.MenuViewModel;
import com.example.coffeehouse.ui.state_holder.ProfileViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {
    private View view;
    private ProfileViewModel profileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_main, container, false);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        profileViewModel.getUser().observe(getViewLifecycleOwner(), userResponse -> {
            if (userResponse == null){
                Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                        .navigate(R.id.action_mainFragment_to_authenticationActivity);
            }
        });
        BottomNavigationView navView = view.findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(view.findViewById(R.id.fr_menu));
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}