package com.example.coffeehouse.data.models;

import androidx.room.Entity;

@Entity(tableName = "coffees")
public class Coffee extends Product {
    public Coffee(String name, float price){
        super(name, price);
    }
}

