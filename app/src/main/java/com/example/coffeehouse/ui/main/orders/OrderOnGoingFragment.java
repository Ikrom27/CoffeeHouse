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
import com.example.coffeehouse.ui.state_holder.OrderHistoryViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.OrderOnGoingAdapter;

public class OrderOnGoingFragment extends Fragment {
    private OrderHistoryViewModel orderHistoryViewModel;
    private RecyclerView recyclerView;
    private OrderOnGoingAdapter orderOnGoingAdapter;
    private ConstraintLayout emptyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_products, container, false);
        this.recyclerView = view.findViewById(R.id.rv_products);
        this.emptyList = view.findViewById(R.id.container_no_order);
        this.orderHistoryViewModel = new ViewModelProvider(requireActivity()).get(OrderHistoryViewModel.class);
        this.orderOnGoingAdapter = new OrderOnGoingAdapter();


        recyclerView.setAdapter(orderOnGoingAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        orderHistoryViewModel.getOrderHistory(false).observe(getViewLifecycleOwner(), orderHistoryResponses -> {
            if (orderHistoryResponses.size() > 0){
                emptyList.setVisibility(View.GONE);
                orderOnGoingAdapter.setOrderHistoryResponseList(orderHistoryResponses);
            }
            else{
                emptyList.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}