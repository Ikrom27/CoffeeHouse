package com.example.coffeehouse.data.models;

public class Product {
    private String name;
    private int price;
    private String description;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    Product(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
