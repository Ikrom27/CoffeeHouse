package com.example.coffeehouse.ui.state_holder.adapter;


import android.annotation.SuppressLint;

import com.example.coffeehouse.data.models.Product;
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

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> productList;
    private OnProductClickListener mListener;
    private String TAG = "ProductAdapter";

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products_grid, parent, false);
        return new ProductViewHolder(view);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText("$ " + Double.toString(product.getPrice()));
        Log.d(TAG, product.getImage());
        Picasso.get()
                .load(product.getImage())
                .placeholder(R.drawable.ic_product)
                .into(holder.imProductImage);
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClick(product, position);
            }
        });
    }


    public interface OnProductClickListener {
        void onClick(Product product, int position);
    }

    public void onItemClickListener(OnProductClickListener listener){
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        if (productList == null){
            return 0;
        }
        return productList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public TextView tvProductName;
        public TextView tvProductPrice;
        public ImageView imProductImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imProductImage = itemView.findViewById(R.id.iv_product_image);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}