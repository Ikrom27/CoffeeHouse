package com.example.coffeehouse.data.data_source.impl;

import com.example.coffeehouse.data.models.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoffeeArrayDataSource {
    private static CoffeeArrayDataSource instance;
    private final List<Coffee> coffeeList = new ArrayList<>();
    private CoffeeArrayDataSource() {
        String[] coffeeName = {"Americano", "Cappuccino", "Flat white", "Mocha"};
        int n = 20;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            coffeeList.add(new Coffee(coffeeName[random.nextInt(coffeeName.length)],
                                      random.nextInt(5)));
        }
    }
    public static CoffeeArrayDataSource getInstance() {
        if (instance == null) {
            instance = new CoffeeArrayDataSource();
        }
        return instance;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
    }

    public void updateCoffee(Coffee coffee) {
        int index = coffeeList.indexOf(coffee);
        if (index != -1) {
            coffeeList.set(index, coffee);
        }
    }

    public void deleteCoffee(Coffee coffee) {
        coffeeList.remove(coffee);
    }
}
