package com.example.coffeehouse.data.data_source.orders.retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.user.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.models.OrderReceive;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitOrderDataSource {
    private Retrofit retrofit;
    private MutableLiveData<Integer> orderID;
    private String TAG = "RetrofitOrderDataSource";

    public RetrofitOrderDataSource(){
        retrofit = RetrofitFactory.getRetrofit("");
    }

    public MutableLiveData<Integer> push(OrderReceive orderReceive) {
        Log.d(TAG, "pushing");
        orderID = new MutableLiveData<>();
        OrderAPI orderAPI = retrofit.create(OrderAPI.class);
        orderAPI.push(orderReceive).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()){
                    orderID.setValue(response.body());
                    Log.d(TAG, "response successful with body " + response.body());
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
        return orderID;
    }
}
