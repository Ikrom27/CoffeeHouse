package com.example.coffeehouse.data.data_source.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.base.products.retrofit.PlaceholderAPI;
import com.example.coffeehouse.data.base.products.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.models.PlaceholderPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WebDataSource {
    private String TAG = "WebDataSource";
    private final Retrofit retrofit;
    private final String URL = "https://api.placeholder.com/";

    public WebDataSource() {
        this.retrofit = RetrofitFactory.getRetrofit(URL);
    }

    public MutableLiveData<PlaceholderPost> getPost(int postId) {
        MutableLiveData<PlaceholderPost> postLiveData = new MutableLiveData<>();
        PlaceholderAPI service = retrofit.create(PlaceholderAPI.class);
        service.getPost(postId).enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    postLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {
                Log.e(TAG, "getPost response error");
            }
        });
        return postLiveData;
    }

    public MutableLiveData<PlaceholderPost> pushPost(PlaceholderPost placeholderPost) {
        MutableLiveData<PlaceholderPost> pushedLiveData = new MutableLiveData<>();
        PlaceholderAPI service = retrofit.create(PlaceholderAPI.class);
        service.pushPost(placeholderPost).enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    pushedLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {
                Log.e(TAG, "pushPost response error");
            }
        });
        return pushedLiveData;
    }

    public MutableLiveData<List<PlaceholderPost>> getAllPosts() {
        MutableLiveData<List<PlaceholderPost>> postLiveData = new MutableLiveData<>();
        PlaceholderAPI service = retrofit.create(PlaceholderAPI.class);
        service.getAllPosts().enqueue(new Callback<List<PlaceholderPost>>() {

            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()){
                    postLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {
                Log.e(TAG, "getPosts response error");
            }
        });
        return postLiveData;
    }
}
