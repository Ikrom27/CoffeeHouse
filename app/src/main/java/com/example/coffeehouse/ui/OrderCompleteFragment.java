package com.example.coffeehouse.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.coffeehouse.R;

public class OrderCompleteFragment extends DialogFragment {
    private TextView tvTotal;
    private TextView tvOrderId;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_complete, container, false);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        tvTotal = view.findViewById(R.id.tv_order_total);
        tvOrderId = view.findViewById(R.id.tv_order_id);

        if (getArguments() != null){
            double total = getArguments().getDouble("total");
            int id = getArguments().getInt("id");
            tvTotal.setText("$" + total);
            tvOrderId.setText("#"+id);
        }

        return view;
    }
    public static String TAG = "OrderCompleteFragment";
}