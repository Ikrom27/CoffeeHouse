package com.example.coffeehouse.data.data_source.products.retrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.user.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.RemoteProductDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RemoteProductDataSourceImpl implements RemoteProductDataSource {
    private String TAG = "RemoteProductDataSourceImpl";
    private Retrofit retrofit;
    private String URL = "http://85.193.90.163:8080";

    public RemoteProductDataSourceImpl(){
        this.retrofit = RetrofitFactory.getRetrofit(URL);
    }

    @Override
    public LiveData<List<Product>> getProductList() {
        MutableLiveData<List<Product>> productList = new MutableLiveData<>();
        ProductAPI productAPI = retrofit.create(ProductAPI.class);
        productAPI.getProductList().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products = response.body();
                    productList.postValue(products); // Use postValue instead of setValue
                } else {
                    Log.e("API", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("API", "Request failed: " + t.getMessage());
            }
        });
        return productList;
    }
}