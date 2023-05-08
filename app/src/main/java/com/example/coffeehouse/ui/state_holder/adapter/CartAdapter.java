package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.ui.state_holder.CartViewModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Cart> cartList;
    private CartViewModel cartViewModel;

    public CartAdapter(List<Cart> cartList){
        this.cartList = cartList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProductList(List<Cart>  productList) {
        this.cartList = productList;
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
        Cart cart = cartList.get(position);
        holder.tvProductName.setText(cart.getProductName());
        holder.tvProductPrice.setText(Double.toString(cart.getProductPrice()));
        holder.ivProductImage.setImageResource(Integer.parseInt(cart.getImagePath()));
    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName;
        public TextView tvProductPrice;
        public ImageView ivProductImage;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProductImage = itemView.findViewById(R.id.iv_product_image);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
