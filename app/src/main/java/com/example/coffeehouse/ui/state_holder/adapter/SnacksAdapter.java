package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.Snack;

import java.util.List;

public class SnacksAdapter extends RecyclerView.Adapter<SnacksAdapter.SnacksViewHolder> {
    private List<Snack> snackList;
    private OnClickListener clickListener;

    @NonNull
    @Override
    public SnacksAdapter.SnacksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu_product, parent, false);
        return new SnacksViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SnacksAdapter.SnacksViewHolder holder, int position) {
        Snack snack = snackList.get(position);
        holder.tvProductName.setText(snack.getName());
        holder.tvProductPrice.setText("$ " + Double.toString(snack.getPrice()));
        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null){
                clickListener.onClick(snack, position);
            }
        });
    }

    public interface OnClickListener{
        void onClick(Snack snack, int position);
    }

    public void onItemClickListener(OnClickListener listener){
        clickListener = listener;
    }

    @Override
    public int getItemCount() {
        if (snackList == null){
            return 0;
        }
        return snackList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setSnackList(List<Snack> snacks){
        snackList = snacks;
        notifyDataSetChanged();
    }

    public static class SnacksViewHolder extends RecyclerView.ViewHolder{
        public TextView tvProductName;
        public TextView tvProductPrice;

        public SnacksViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
