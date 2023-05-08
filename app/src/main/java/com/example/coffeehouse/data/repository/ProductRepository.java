package com.example.coffeehouse.data.repository;

import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Snack;

import java.util.List;

public interface ProductRepository {

    LiveData<List<Snack>> getSnackList();
}
