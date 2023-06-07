package com.example.coffeehouse.data.data_source.orders.retrofit;

import com.example.coffeehouse.data.models.OrderHistoryResponse;
import com.example.coffeehouse.data.models.OrderReceive;
import com.example.coffeehouse.data.models.OrderResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderAPI {
    @POST("/api/v1/orders")
    Call<Integer> push(@Body OrderReceive orderReceive);
    @GET("api/v1/orders/users/{id}")
    Call<List<OrderHistoryResponse>> getOrderHistory(@Path("id") int id);
}
