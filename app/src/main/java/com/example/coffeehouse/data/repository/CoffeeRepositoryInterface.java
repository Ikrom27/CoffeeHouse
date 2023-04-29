package com.example.coffeehouse.data.repository;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Coffee;

import java.util.List;

public interface CoffeeRepositoryInterface {
    LiveData<List<Coffee>> getCoffeeList();
    void addCoffee(Coffee coffee);
    void updateCoffee(Coffee coffee);
    void deleteCoffee(Coffee coffee);
}
