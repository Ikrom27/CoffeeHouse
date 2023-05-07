package com.example.coffeehouse.data.repository.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.data_source.impl.CoffeeArrayDataSource;
import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.repository.CoffeeRepository;

import java.util.List;

public class CoffeeRepositoryImpl implements CoffeeRepository {
    private final CoffeeArrayDataSource coffeeArrayDataSource;

    public CoffeeRepositoryImpl() {
        coffeeArrayDataSource = CoffeeArrayDataSource.getInstance();
    }

    @Override
    public LiveData<List<Coffee>> getCoffeeList() {
        MutableLiveData<List<Coffee>> coffeeListLiveData = new MutableLiveData<>();
        coffeeListLiveData.setValue(coffeeArrayDataSource.getCoffeeList());
        return coffeeListLiveData;
    }

    @Override
    public void addCoffee(Coffee coffee) {
        coffeeArrayDataSource.addCoffee(coffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        coffeeArrayDataSource.updateCoffee(coffee);
    }

    @Override
    public void deleteCoffee(Coffee coffee) {
        coffeeArrayDataSource.deleteCoffee(coffee);
    }
}

