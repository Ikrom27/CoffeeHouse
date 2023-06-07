package com.example.coffeehouse.ui.main.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.OrderConfirmViewModel;

public class CartFragment extends Fragment {
    private CartViewModel cartViewModel;
    private OrderConfirmViewModel orderConfirmViewModel;
    private String TAG = "CartFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        orderConfirmViewModel = new ViewModelProvider(requireActivity()).get(OrderConfirmViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartViewModel.getCartList().observe(getViewLifecycleOwner(), productEntities -> {
            if (productEntities.isEmpty()){
                Navigation.findNavController(view.findViewById(R.id.fr_cart_container)).setGraph(R.navigation.navgraph_no_order);
            }
            else{
                Navigation.findNavController(view.findViewById(R.id.fr_cart_container)).setGraph(R.navigation.navgraph_cart);
            }
        });

        orderConfirmViewModel.getOrder().observe(getViewLifecycleOwner(), orderResponse -> {
            if (orderResponse != null){
                cartViewModel.clear();
                Navigation.findNavController(view).navigateUp();
            }
        });

        ImageButton btnBackward = view.findViewById(R.id.bt_back_light);
        btnBackward.setOnClickListener(view1 -> Navigation.findNavController(view1).navigateUp());

    }
}