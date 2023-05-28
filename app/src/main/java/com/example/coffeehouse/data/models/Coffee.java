package com.example.coffeehouse.data.models;

import androidx.room.Entity;

@Entity(tableName = "coffees")
public class Coffee extends Product {
    private String image;
    public Coffee(String name, float price){
        super(name, price);
        this.image = "https://downloader.disk.yandex.ru/preview/a7195e7fddf91a646e5f45e0f64d7f478bd2766fdcb57a8742a8eb74ed39cde0/6473c386/bLJKthXz1AaS7VQUue0uAGls9klPZV_BgPeW5AFZTfBgIjgSkLtHMXILNcYfoW85_dxO1wqsjjWR3GkvF7b2Eg%3D%3D?uid=0&filename=Macchiato.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839";
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

