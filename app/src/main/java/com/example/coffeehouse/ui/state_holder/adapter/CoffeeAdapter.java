package com.example.coffeehouse.ui.state_holder.adapter;


import android.annotation.SuppressLint;
import com.squareup.picasso.Picasso;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.Coffee;
import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>{
    private List<Coffee> coffeeList;
    private OnCoffeeClickListener mListener;
    private String TAG = "CoffeeAdapter";

    @NonNull
    @Override
    public CoffeeAdapter.CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products_grid, parent, false);
        return new CoffeeViewHolder(view);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CoffeeAdapter.CoffeeViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
        holder.tvProductName.setText(coffee.getName());
        holder.tvProductPrice.setText("$ " + Double.toString(coffee.getPrice()));
        Log.d(TAG, coffee.getImage());
        Picasso.get()
                .load(coffee.getImage())
                .placeholder(R.drawable.ic_product)
                .into(holder.imProductImage);
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
        if (coffeeList == null){
            return 0;
        }
        return coffeeList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
        notifyDataSetChanged();
    }

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder{
        public TextView tvProductName;
        public TextView tvProductPrice;
        public ImageView imProductImage;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            imProductImage = itemView.findViewById(R.id.iv_product_image);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}