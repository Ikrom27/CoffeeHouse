package com.example.coffeehouse.ui.main.cart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.CartAdapter;


public class CartFilledFragment extends Fragment {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private CartViewModel cartViewModel;
    private Button btnBuy;
    private TextView tvTotalPrice;
    private View view;
    private String TAG = "CartFilledFragment";
    private double total = 0;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_cart_filled, container, false);
        this.recyclerView = view.findViewById(R.id.rv_container);
        this.btnBuy = view.findViewById(R.id.btn_pay);
        this.tvTotalPrice = view.findViewById(R.id.tv_total_text);
        this.cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        this.cartAdapter = new CartAdapter();


        //SHOW RECYCLE VIEW
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartViewModel.getCartList().observe(getViewLifecycleOwner(), products -> {
            cartAdapter.setProductList(products);
        });

        //SHOW TOTAL
        cartViewModel.getTotalPrice().observe(getViewLifecycleOwner(), totalPrice -> {
            this.total = totalPrice;
            tvTotalPrice.setText("$ " + total);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //SHOW ORDER CONFIRM
        btnBuy.setOnClickListener(view1 -> {
            Log.d(TAG, "Buy handle");
            ConfirmOrderFragment fragment = new ConfirmOrderFragment();
            Bundle args = new Bundle();
            args.putDouble("total", total);
            fragment.setArguments(args);
            fragment.show(getChildFragmentManager(), ConfirmOrderFragment.TAG);
        });
    }
}