package com.example.coffeehouse.data.data_source.impl;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Snack;
import com.example.coffeehouse.data.data_source.RetrofitProductDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RetrofitProductDataSourceImpl implements RetrofitProductDataSource {
    @Override
    public void fetch() {

    }

    @Override
    public List<Coffee> getCoffees() {
        String[] coffeeNames = {"Espresso", "Cappuccino", "Latte", "Americano", "Mocha",
                "Macchiato", "Flat White", "Affogato", "Turkish Coffee", "Irish Coffee",
                "Vietnamese Coffee", "Colombian Coffee", "Ethiopian Coffee", "Brazilian Coffee",
                "Costa Rican Coffee", "Guatemalan Coffee", "Jamaican Coffee", "Mexican Coffee",
                "Panamanian Coffee", "Hawaiian Coffee"};
        List<Coffee> coffees = new ArrayList<>();
        for (String name: coffeeNames){
            Random random = new Random();
            coffees.add(new Coffee(name, random.nextInt(15 - 1) + 1));
        }
        return coffees;
    }

    @Override
    public List<Snack> getSnacks() {
        String[] snackNames = {"Biscotti", "Croissant", "Scone", "Muffin", "Cinnamon roll",
                "Bagel", "Fruit cup", "Yogurt parfait", "Cheese plate", "Hummus dip",
                "Pretzel", "Trail mix", "Popcorn", "Chips", "Granola bar"};
        List<Snack> snacks = new ArrayList<>();
        for (String name: snackNames){
            Random random = new Random();
            snacks.add(new Snack(name, random.nextInt(15 - 1) + 1));
        }
        return snacks;
    }

    @Override
    public List<Dessert> getDesserts() {
        String[] dessertNames = {"Chocolate cake", "Cheesecake", "Apple pie", "Carrot cake", "Tiramisu",
                "Key lime pie", "Pecan pie", "Banana bread", "Brownie", "Ice cream",
                "Pumpkin pie", "Fruit tart"};
        List<Dessert> desserts = new ArrayList<>();
        for (String name: dessertNames){
            Random random = new Random();
            desserts.add(new Dessert(name, random.nextInt(15 - 1) + 1));
        }
        return desserts;
    }
}
