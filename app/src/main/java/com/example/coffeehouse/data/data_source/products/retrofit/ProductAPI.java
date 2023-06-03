package com.example.coffeehouse.data.data_source.products.retrofit;


import com.example.coffeehouse.data.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductAPI {
    @GET("/api/v1/products")
    Call<List<Product>> getProductList();
}
