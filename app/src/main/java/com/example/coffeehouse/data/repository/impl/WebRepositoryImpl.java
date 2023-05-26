package com.example.coffeehouse.data.repository.impl;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.base.products.retrofit.PlaceholderAPI;
import com.example.coffeehouse.data.base.products.retrofit.RetrofitFactory;
import com.example.coffeehouse.data.data_source.impl.WebDataSource;
import com.example.coffeehouse.data.models.PlaceholderPost;
import com.example.coffeehouse.data.repository.WebRepository;

import java.util.List;


public class WebRepositoryImpl implements WebRepository {
    private final WebDataSource webDataSource = new WebDataSource();

    @Override
    public MutableLiveData<PlaceholderPost> getPost(int postId) {
        return webDataSource.getPost(postId);
    }

    @Override
    public MutableLiveData<PlaceholderPost> pushPost(PlaceholderPost placeholderPost) {
        return webDataSource.pushPost(placeholderPost);
    }

    @Override
    public MutableLiveData<List<PlaceholderPost>> getAllPosts() {
        return webDataSource.getAllPosts();
    }
}
