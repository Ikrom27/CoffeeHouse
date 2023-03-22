package com.example.coffeehouse;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsList {
    private final String []names;
    private final List<Product> products = new ArrayList<>();

    public ProductsList(String []names){
        this.names = names;
    }

    public List<Product> createProducts(int number){
        while (number > 0){
            Random rand = new Random();
            Product product = new Product(names[rand.nextInt(names.length)], rand.nextInt(20));
            products.add(product);
            number--;
        }
        return products;
    }
}