package com.example.coffeehouse.data.models;

import androidx.room.Entity;

@Entity(tableName = "snacks")
public class Snack extends Product {
    private String image = "2131230893";

    public Snack(String name, float price) {
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

