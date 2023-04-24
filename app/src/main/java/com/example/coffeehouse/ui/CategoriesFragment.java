package com.example.coffeehouse.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.coffeehouse.R;

public class CategoriesFragment extends Fragment {
    private final String TAG = "CategoriesFragment";
    private final Fragment coffeeFragment = new CategoriesCoffeeFragment();
    private final Fragment snacksFragment = new CategoriesSnacksFragment();

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        AppCompatButton btnSnacks = (AppCompatButton) view.findViewById(R.id.btn_snacks);
        AppCompatButton btnCoffee = (AppCompatButton) view.findViewById(R.id.btn_coffee);

        btnSnacks.setOnClickListener(v->{
            Log.d(TAG, "click handle");
            setFocus(btnSnacks);
            deFocus(btnCoffee);
            if (savedInstanceState == null) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_categories_container, snacksFragment).commit();
            }
        });

        btnCoffee.setOnClickListener(v->{
            Log.d(TAG, "click handle");
            setFocus(btnCoffee);
            deFocus(btnSnacks);
            if (savedInstanceState == null) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_categories_container, coffeeFragment).commit();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_categories_container, coffeeFragment).commit();
        }

    }

    private void setFocus(Button button){
        button.setBackgroundResource(R.drawable.btn_primary);
        button.setTextColor(getResources().getColor(R.color.white));
    }

    private void deFocus(Button button){
        button.setBackgroundResource(R.drawable.btn_secondary);
        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_text));
    }
}