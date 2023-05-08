package com.example.coffeehouse.data.models;


import androidx.room.Entity;

@Entity(tableName = "desserts")
public class Dessert extends Product {
    private String image = "2131230869";

    public Dessert(String name, float price) {
        super(name, price);
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getImage() {
        return image;
    }
}
