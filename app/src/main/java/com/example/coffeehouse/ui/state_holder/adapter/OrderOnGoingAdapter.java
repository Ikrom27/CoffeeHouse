package com.example.coffeehouse.ui.state_holder.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.data.models.OrderHistoryResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderOnGoingAdapter extends RecyclerView.Adapter<OrderOnGoingAdapter.OrderOnGoingHolder>{
    private List<OrderHistoryResponse> orderHistoryResponseList = new ArrayList<>();

    private String TAG = "OrderHistoryAdapter";

    @NonNull
    @Override
    public OrderOnGoingAdapter.OrderOnGoingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_on_going, parent, false);
        return new OrderOnGoingAdapter.OrderOnGoingHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderOnGoingHolder holder, int position) {
        OrderHistoryResponse order = orderHistoryResponseList.get(position);

        // Преобразование строки даты в LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(order.getDate(), DateTimeFormatter.ISO_DATE_TIME);

        // Форматирование даты и времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM | HH:mm", Locale.US);
        String formattedDateTime = dateTime.format(formatter);

        holder.tvDate.setText(formattedDateTime);
        holder.tvOrderId.setText("#" + order.getOrderID());
        holder.tvTotal.setText("$" + order.getTotal());
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setOrderHistoryResponseList(List<OrderHistoryResponse> orderHistoryResponseList){
        this.orderHistoryResponseList = orderHistoryResponseList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return orderHistoryResponseList.size();
    }

    public static class OrderOnGoingHolder extends RecyclerView.ViewHolder{
        public TextView tvDate;
        public TextView tvOrderId;
        public TextView tvTotal;

        public OrderOnGoingHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvOrderId = itemView.findViewById(R.id.tv_order_id);
            tvTotal = itemView.findViewById(R.id.tv_total);
        }
    }
}
