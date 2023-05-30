package com.example.coffeehouse.data.data_source.impl;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Snack;
import com.example.coffeehouse.data.data_source.RetrofitProductDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RetrofitProductDataSourceImpl implements RetrofitProductDataSource {
    @Override
    public void fetch() {

    }

    @Override
    public List<Coffee> getCoffees() {
        String[] coffeeNames = {"Espresso", "Cappuccino", "Latte", "Americano", "Mocha",
                "Macchiato", "Flat White", "Affogato", "Mexican"};
        List<Coffee> coffees = new ArrayList<>();
        String[] images = {
                "https://downloader.disk.yandex.ru/preview/52089e741107cdc8476b35ae1af1650ba92ea432cec501b12547953c9f6e1ce1/6473c386/B4rfFsukRAXIwZ1eDNUyc2ls9klPZV_BgPeW5AFZTfDZH7rIu3nfe1ETcM5ze9zbKxShk9a23PZN_iD06fnTNg%3D%3D?uid=0&filename=Espresso.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/1d1dcec33db773383a301a99d8756d34112459f7657b7865eb2a42c4d749a5e5/6473c386/L9WWgNMmHQEovcSmuGVU12ls9klPZV_BgPeW5AFZTfDi3BB952q0-7Y_aJcXiICoEpERE_qefE7fz-tI7Vo6aw%3D%3D?uid=0&filename=Cappuccino.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/d42e78cc6e0ee5ff7fecabcd33601a6ea1f71e5741de628137782ca48683751d/6473c386/_1clABEWg-N0OrP0UXVUvGls9klPZV_BgPeW5AFZTfA1osAGT20GDvKqu1POrtgqOZJFcsOxTflz2w_PFZcdhA%3D%3D?uid=0&filename=Latte.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/6da0b02a10e311fba6a84a5478ecdc5ca39ec1463265831051701dc425ce888a/6473c386/iOxxHhAMfWb-RalJ_9QB8yM6IzAv4HwouQzKmhAVmz2nuC5Xepl6HbQfZeiI7_qze-G-ySFandQaK4ztgMZHHQ%3D%3D?uid=0&filename=Americano.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/7b3b1f9309b19673d87c6a7eccf4faa1b933f2936b84dada892fbda1837907a2/6473c386/KVjqPRfaspxvqbEvLxpk0ACZ6onshXRChXiQcR0aEB9h1BKh8CSNufG5I6QrJcSTqquJQ68wSTIyeLaki7pLvA%3D%3D?uid=0&filename=Mocha.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/a7195e7fddf91a646e5f45e0f64d7f478bd2766fdcb57a8742a8eb74ed39cde0/6473c386/bLJKthXz1AaS7VQUue0uAGls9klPZV_BgPeW5AFZTfBgIjgSkLtHMXILNcYfoW85_dxO1wqsjjWR3GkvF7b2Eg%3D%3D?uid=0&filename=Macchiato.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/fa9055a3b425698d7d997af85e3787c93d417a78648f0089acd3b80649a3119f/6473c386/6RDkKyLq54PcX6X4nfgkFWls9klPZV_BgPeW5AFZTfDM6I74uvREvwPMmdrbzYZepTHb6BFRSibZgMrOOeNwPg%3D%3D?uid=0&filename=Flat%20White.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/22bbc795098e404bb2a15680b741fe9d798f9b8a8c51222405eb5dd86a22b3c3/6473c386/aLQIBwh3GQo9bbegJ3nhvGls9klPZV_BgPeW5AFZTfDXddrKPA3l7BC8nPr8h3h730aX5oqn2JI2okKmia-q1A%3D%3D?uid=0&filename=Affogato.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
                "https://downloader.disk.yandex.ru/preview/a7718bcc0868cfd072f488e66a350b65404d2e72bcdc4dfff34f7c1ccf11a0a0/6473c386/_K4Lf6tP8w0dWFpIf24OGmls9klPZV_BgPeW5AFZTfDl2P5VUGhbpRaC5I9pAj5HjLnc7ciuo8gQpgKO-PELzA%3D%3D?uid=0&filename=Mexican.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1174x839",
        };
        for (int i = 0; i<coffeeNames.length; i++){
            Random random = new Random();
            Coffee coffee = new Coffee(coffeeNames[i], random.nextInt(15 - 1) + 1);
            coffee.setImage(images[i]);
            coffees.add(coffee);
        }
        return coffees;
    }

    @Override
    public List<Snack> getSnacks() {
        String[] snackNames = {"Biscotti", "Croissant", "Scone", "Muffin", "Cinnamon roll",
                "Bagel", "Fruit cup", "Yogurt parfait", "Cheese plate", "Hummus dip",
                "Pretzel", "Trail mix", "Popcorn", "Chips", "Granola bar"};
        List<Snack> snacks = new ArrayList<>();
        for (String name: snackNames){
            Random random = new Random();
            snacks.add(new Snack(name, random.nextInt(15 - 1) + 1));
        }
        return snacks;
    }

    @Override
    public List<Dessert> getDesserts() {
        String[] dessertNames = {"Chocolate cake", "Cheesecake", "Apple pie", "Carrot cake", "Tiramisu",
                "Key lime pie", "Pecan pie", "Banana bread", "Brownie", "Ice cream",
                "Pumpkin pie", "Fruit tart"};
        List<Dessert> desserts = new ArrayList<>();
        for (String name: dessertNames){
            Random random = new Random();
            desserts.add(new Dessert(name, random.nextInt(15 - 1) + 1));
        }
        return desserts;
    }
}
