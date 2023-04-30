package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.ui.main.menu.MenuCoffeeFragment;
import com.example.coffeehouse.ui.state_holder.MenuCoffeeViewModel;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>{
    private List<Coffee> coffeeList;
    private OnCoffeeClickListener mListener;

    private MenuCoffeeViewModel viewModel;

    public CoffeeAdapter(MenuCoffeeViewModel viewModel){
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CoffeeAdapter.CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categories_coffee, parent, false);
        return new CoffeeViewHolder(view);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CoffeeAdapter.CoffeeViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
        holder.tvCoffeeName.setText(coffee.getName());
        holder.tvCoffeePrice.setText(Double.toString(coffee.getPrice()));
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClick(coffee, position);
            }
        });
    }

    public interface OnCoffeeClickListener{
        void onClick(Coffee coffee, int position);
    }

    public void onItemClickListener(OnCoffeeClickListener listener){
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
        notifyDataSetChanged();
    }

    static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCoffeeName;
        public TextView tvCoffeePrice;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCoffeeName = itemView.findViewById(R.id.tv_product_name);
            tvCoffeePrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}