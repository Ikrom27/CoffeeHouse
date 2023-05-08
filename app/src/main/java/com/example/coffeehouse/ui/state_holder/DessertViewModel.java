package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class DessertViewModel extends AndroidViewModel {
    private final ProductRepositoryImpl productRepository;

    public DessertViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepositoryImpl(application);
    }

    public LiveData<List<Dessert>> getDessertList(){
        return productRepository.getDessertList();
    }
}
