package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.Dessert;

import java.util.List;

public class DessertAdapter extends RecyclerView.Adapter<DessertAdapter.DessertViewHolder> {
    private List<Dessert> dessertList;
    private OnClickListener clickListener;

    @NonNull
    @Override
    public DessertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu_product, parent, false);
        return new DessertViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DessertAdapter.DessertViewHolder holder, int position) {
        Dessert dessert = dessertList.get(position);
        holder.tvProductName.setText(dessert.getName());
        holder.tvProductPrice.setText("$ " + Double.toString(dessert.getPrice()));
        Log.d("IC", Integer.toString(R.drawable.ic_dessert));
        holder.imProductImage.setImageResource(R.drawable.ic_dessert);
        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null){
                clickListener.onClick(dessert, position);
            }
        });
    }

    public interface OnClickListener{
        void onClick(Dessert dessert, int position);
    }

    public void onItemClickListener(OnClickListener listener){
        clickListener = listener;
    }

    @Override
    public int getItemCount() {
        if (dessertList == null){
            return 0;
        }
        return dessertList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDessertList(List<Dessert> dessert){
        dessertList = dessert;
        notifyDataSetChanged();
    }

    public static class DessertViewHolder extends RecyclerView.ViewHolder{
        public TextView tvProductName;
        public TextView tvProductPrice;
        public ImageView imProductImage;

        public DessertViewHolder(@NonNull View itemView) {
            super(itemView);
            imProductImage = itemView.findViewById(R.id.iv_product_image);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
