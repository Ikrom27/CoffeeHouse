package com.example.coffeehouse.data.models;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class UserByID extends User {
    @PrimaryKey
    @SerializedName("id")
    private int id;

    public UserByID(int id, String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber, password);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

