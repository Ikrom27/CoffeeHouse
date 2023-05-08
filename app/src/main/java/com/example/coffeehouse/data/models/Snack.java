package com.example.coffeehouse.data.models;

import androidx.room.Entity;

@Entity(tableName = "snacks")
public class Snack extends Product {

    public Snack(String name, float price) {
        super(name, price);
    }

    // Геттеры и сеттеры для всех полей
}

