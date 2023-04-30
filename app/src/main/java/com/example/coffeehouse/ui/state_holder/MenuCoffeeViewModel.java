package com.example.coffeehouse.ui.state_holder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeehouse.data.products.remote.repository.CoffeeRepository;
import com.example.coffeehouse.data.products.remote.repository.CoffeeRepositoryInterface;
import com.example.coffeehouse.data.models.Coffee;

import java.util.List;

public class MenuCoffeeViewModel extends ViewModel {
    private final CoffeeRepositoryInterface coffeeRepository;
    private LiveData<List<Coffee>> coffeeList;

    public MenuCoffeeViewModel() {
        coffeeRepository = new CoffeeRepository();
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

