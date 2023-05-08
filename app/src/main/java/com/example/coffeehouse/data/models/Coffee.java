package com.example.coffeehouse.data.models;

import androidx.room.Entity;

@Entity(tableName = "coffees")
public class Coffee extends Product {
    private String image = "2131230889";
    public Coffee(String name, float price){
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

