package com.example.coffeehouse.data.data_source.orders.retrofit;

import android.util.Log;

import com.example.coffeehouse.data.data_source.products.retrofit.ProductAPI;
import com.example.coffeehouse.data.data_source.user.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.models.OrderItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitOrderDataSource {
    private Retrofit retrofit;
    private String TAG = "RetrofitOrderDataSource";

    public RetrofitOrderDataSource(){
        retrofit = RetrofitFactory.getRetrofit("");
    }

    public void push(List<OrderItem> orderItemList) {
        OrderReceive orderReceive = new OrderReceive(100, 1, orderItemList);
        OrderAPI orderAPI = retrofit.create(OrderAPI.class);
        orderAPI.push(orderReceive).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "is ok with body " + response.body());
                }
                else {
                    Log.e(TAG, "response not Successful");
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(TAG, "onFailure error");
            }
        });
    }
}
