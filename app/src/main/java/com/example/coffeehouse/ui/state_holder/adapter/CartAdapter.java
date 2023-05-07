package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.base.products.room.dao.ProductEntity;
import com.example.coffeehouse.ui.state_holder.CartViewModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<ProductEntity> productList;
    private CartViewModel cartViewModel;

    public CartAdapter(List<ProductEntity> productList){
        this.productList = productList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categories_coffee, parent, false);
        return new CartViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        ProductEntity product = productList.get(position);
        holder.tvProductName.setText(product.getProductName());
        holder.tvProductPrice.setText(Double.toString(product.getProductPrice()));
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName;
        public TextView tvProductPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
