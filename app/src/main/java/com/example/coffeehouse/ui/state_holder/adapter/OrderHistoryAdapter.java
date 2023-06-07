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

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryHolder> {
    private List<OrderHistoryResponse> orderHistoryResponseList = new ArrayList<>();

    private String TAG = "OrderHistoryAdapter";

    @NonNull
    @Override
    public OrderHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_history, parent, false);
        return new OrderHistoryAdapter.OrderHistoryHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderHistoryHolder holder, int position) {
        OrderHistoryResponse order = orderHistoryResponseList.get(position);

        // Преобразование строки даты в LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(order.getDate(), DateTimeFormatter.ISO_DATE_TIME);

        // Форматирование даты и времени
        int day = dateTime.getDayOfMonth();
        int month = dateTime.getMonthValue();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();

        String formattedDateTime = String.format("%02d-%02d | %02d:%02d", day, month, hour, minute);

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

    public static class OrderHistoryHolder extends RecyclerView.ViewHolder{
        public TextView tvDate;
        public TextView tvOrderId;
        public TextView tvTotal;

        public OrderHistoryHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvOrderId = itemView.findViewById(R.id.tv_order_id);
            tvTotal = itemView.findViewById(R.id.tv_total);
        }
    }
}
