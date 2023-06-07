package com.example.coffeehouse.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.OrderConfirmViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ConfirmOrderFragment extends BottomSheetDialogFragment {

    public static String TAG = "ConfirmOrderFragment";
    private TextView tvTotal;
    private AppCompatButton btnPay;
    private OrderConfirmViewModel orderConfirmViewModel;
    private Double total = (double) -1;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_order, container, false);
        tvTotal = view.findViewById(R.id.tv_total_text);
        btnPay = view.findViewById(R.id.btn_pay);

        orderConfirmViewModel = new ViewModelProvider(requireActivity()).get(OrderConfirmViewModel.class);

        if (getArguments() != null){
            total = getArguments().getDouble("total");
            tvTotal.setText(Double.toString(total));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPay.setOnClickListener(view1 -> orderConfirmViewModel.getOrderList().observe(getViewLifecycleOwner(), productList -> {
        if (productList != null) {
            orderConfirmViewModel.push(productList, total);
        }
    }));
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}