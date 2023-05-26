package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.PlaceholderPost;
import com.example.coffeehouse.data.repository.WebRepository;
import com.example.coffeehouse.data.repository.impl.WebRepositoryImpl;

import java.util.List;


public class WebViewModel extends AndroidViewModel {
    private final WebRepository repository;

    public WebViewModel(@NonNull Application application) {
        super(application);
        repository = new WebRepositoryImpl();
    }
    public MutableLiveData<PlaceholderPost> getPost() {
        return repository.getPost(1);
    }

    public MutableLiveData<PlaceholderPost> pushPost(String title, String body) {
        PlaceholderPost placeholderPost = new PlaceholderPost(3212, 423, title, body);
        return repository.pushPost(placeholderPost);
    }

    public MutableLiveData<List<PlaceholderPost>> getAllPosts() {
        return repository.getAllPosts();
    }
}
