package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Snack;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class SnacksViewModel extends AndroidViewModel {
    private final ProductRepositoryImpl productRepository;
    public SnacksViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepositoryImpl(application);
    }

    public LiveData<List<Snack>> getSnackList(){
        return productRepository.getSnackList();
    }
}
