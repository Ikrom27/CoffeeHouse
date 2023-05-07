package com.example.coffeehouse.ui.main.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;


public class OopsFragment extends Fragment {
    private Button btnClear;
    private CartViewModel cartViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oops, container, false);
        btnClear = view.findViewById(R.id.btn_clear);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnClear.setOnClickListener(view1 -> cartViewModel.clear());
    }
}