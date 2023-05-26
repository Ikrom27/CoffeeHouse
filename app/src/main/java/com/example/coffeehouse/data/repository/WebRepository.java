package com.example.coffeehouse.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.PlaceholderPost;

import java.util.List;

public interface WebRepository {
    MutableLiveData<PlaceholderPost> getPost(int postId);
    MutableLiveData<PlaceholderPost> pushPost(PlaceholderPost placeholderPost);
    MutableLiveData<List<PlaceholderPost>> getAllPosts();
}
