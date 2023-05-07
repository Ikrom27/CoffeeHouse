package com.example.coffeehouse.ui.state_holder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeehouse.data.repository.impl.CoffeeRepositoryImpl;
import com.example.coffeehouse.data.repository.CoffeeRepository;
import com.example.coffeehouse.data.models.Coffee;

import java.util.List;

public class MenuCoffeeViewModel extends ViewModel {
    private final CoffeeRepository coffeeRepository;

    public MenuCoffeeViewModel() {
        coffeeRepository = new CoffeeRepositoryImpl();
    }

    public LiveData<List<Coffee>> getCoffeeList() {
        return coffeeRepository.getCoffeeList();
    }

    public void addCoffee(Coffee coffee) {
        coffeeRepository.addCoffee(coffee);
    }

    public void updateCoffee(Coffee coffee) {
        coffeeRepository.updateCoffee(coffee);
    }

    public void deleteCoffee(Coffee coffee) {
        coffeeRepository.deleteCoffee(coffee);
    }
}

