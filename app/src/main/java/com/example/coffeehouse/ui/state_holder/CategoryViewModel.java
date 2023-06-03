package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private final ProductRepositoryImpl productRepository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepositoryImpl(application);
    }

    public LiveData<List<Product>> getProductList(String category) {
        return productRepository.getProductList(category);
    }
}

