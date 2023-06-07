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
import com.example.coffeehouse.ui.ConfirmOrderFragment;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.OrderConfirmViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.CartAdapter;


public class CartRecycleViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private CartViewModel cartViewModel;
    private Button btnBuy;
    private TextView tvTotalPrice;
    private View view;
    private OrderConfirmViewModel orderConfirmViewModel;
    private String TAG;
    private double total = 0;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart_recycle_view, container, false);
        recyclerView = view.findViewById(R.id.rv_container);
        btnBuy = view.findViewById(R.id.btn_pay);
        tvTotalPrice = view.findViewById(R.id.tv_total_text);

        this.cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.getCartList().observe(getViewLifecycleOwner(), products -> {
            cartAdapter = new CartAdapter(products);
            recyclerView.setAdapter(cartAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        cartViewModel.getTotalPrice().observe(getViewLifecycleOwner(), totalPrice -> {
            this.total = totalPrice;
            tvTotalPrice.setText("$ " + total);
        });



        orderConfirmViewModel = new ViewModelProvider(this).get(OrderConfirmViewModel.class);
        orderConfirmViewModel.getOrder().observe(getViewLifecycleOwner(), orderResponse -> {
            Log.d(TAG, "FUCK");
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBuy.setOnClickListener(view1 -> {
            ConfirmOrderFragment fragment = new ConfirmOrderFragment();
            Bundle args = new Bundle();
            args.putDouble("total", total);
            fragment.setArguments(args);
            fragment.show(getChildFragmentManager(), ConfirmOrderFragment.TAG);
        });
    }
}