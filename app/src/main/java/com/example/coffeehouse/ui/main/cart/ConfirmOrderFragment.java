package com.example.coffeehouse.ui.main.cart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.OrderConfirmViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;


public class ConfirmOrderFragment extends BottomSheetDialogFragment {

    public static String TAG = "ConfirmOrderFragment";
    private TextView tvTotal;
    private AppCompatButton btnPay;
    private OrderConfirmViewModel orderConfirmViewModel;
    private RadioGroup radioGroup;
    private RadioButton payMethod = null;
    private Double total = (double) -1;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_order, container, false);
        this.tvTotal = view.findViewById(R.id.tv_total_text);
        this.btnPay = view.findViewById(R.id.btn_pay);
        this.orderConfirmViewModel = new ViewModelProvider(requireActivity()).get(OrderConfirmViewModel.class);
        this.radioGroup = view.findViewById(R.id.rg_pay);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                payMethod = view.findViewById(checkedId);
            }
        });

        //SHOW TOTAL
        if (getArguments() != null){
            total = getArguments().getDouble("total");
            tvTotal.setText(Double.toString(total));
        }


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //PUSH ORDER
        btnPay.setOnClickListener(view1 -> orderConfirmViewModel.getOrderList().observe(getViewLifecycleOwner(), productList -> {
            if (payMethod != null){
                if (payMethod.getText() == getString(R.string.title_pay_in_shop)){
                    if (productList != null) {
                        orderConfirmViewModel.push(productList, total);
                    }
                } else if (payMethod.getText() == getString(R.string.title_pay_by_card)) {
                    Toast.makeText(getContext(),
                            "Google Pay is not supported yet",
                            Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getContext(),
                        "Please, choose payment method",
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }


    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}