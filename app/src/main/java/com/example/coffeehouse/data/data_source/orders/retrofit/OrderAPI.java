package com.example.coffeehouse.data.data_source.orders.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OrderAPI {
    @POST("/api/v1/orders")
    Call<Integer> push(@Body OrderReceive orderReceive);
}
