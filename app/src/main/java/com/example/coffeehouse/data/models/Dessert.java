package com.example.coffeehouse.data.models;


import androidx.room.Entity;

@Entity(tableName = "desserts")
public class Dessert extends Product {

    public Dessert(String name, float price) {
        super(name, price);
    }

    // Геттеры и сеттеры для всех полей
}
