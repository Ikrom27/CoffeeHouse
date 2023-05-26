package com.example.coffeehouse.data.base.products.retrofit;


import com.example.coffeehouse.data.models.PlaceholderPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlaceholderAPI {
    @GET("posts/{postId}")
    Call<PlaceholderPost> getPost(@Path("postId") int postId);

    @POST("posts")
    Call<PlaceholderPost> pushPost(@Body PlaceholderPost placeholderPost);

    @GET("posts")
    Call<List<PlaceholderPost>> getAllPosts();
}

