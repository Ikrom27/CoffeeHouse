package com.example.coffeehouse.ui.main.orders;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.CategoryViewModel;
import com.example.coffeehouse.ui.state_holder.OrderHistoryViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.OrderHistoryAdapter;
import com.example.coffeehouse.ui.state_holder.adapter.ProductAdapter;


public class OrderHistoryFragment extends Fragment {
    private OrderHistoryViewModel orderHistoryViewModel;
    private RecyclerView recyclerView;
    private OrderHistoryAdapter orderHistoryAdapter;
    private ConstraintLayout emptyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_products, container, false);
        this.recyclerView = view.findViewById(R.id.rv_products);
        this.emptyList = view.findViewById(R.id.container_no_order);
        this.orderHistoryViewModel = new ViewModelProvider(requireActivity()).get(OrderHistoryViewModel.class);
        this.orderHistoryAdapter = new OrderHistoryAdapter();


        recyclerView.setAdapter(orderHistoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        orderHistoryViewModel.getOrderHistory(true).observe(getViewLifecycleOwner(), orderHistoryResponses -> {
            if (orderHistoryResponses.size() > 0){
                emptyList.setVisibility(View.GONE);
                orderHistoryAdapter.setOrderHistoryResponseList(orderHistoryResponses);
            }
            else{
                emptyList.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}