package com.example.coffeehouse.data.data_source.products.retrofit;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.data_source.products.RemoteProductDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RemoteProductDataSourceImpl implements RemoteProductDataSource {
    @Override
    public List<Product> getProductList() {
        String[] coffeeNames = {"EspressoNato", "Cappuccino", "Latte", "Americano", "Mocha",
                "Macchiato", "Flat White", "Affogato", "Mexican"};
        List<Product> products = new ArrayList<>();
        for (int i = 0; i<coffeeNames.length; i++){
            Random random = new Random();
            Product product = new Product(coffeeNames[i], random.nextInt(15 - 1) + 1);
            product.setImage("https://downloader.disk.yandex.ru/preview/");
            product.setCategory("coffee");
            products.add(product);
        }
        String[] snackNames = {"Croissants", "Biscotti", "Mini Muffins", "Cinnamon Rolls", "Fruit Tart lets"};
        for (int i = 0; i<snackNames.length; i++){
            Random random = new Random();
            Product product = new Product(snackNames[i], random.nextInt(15 - 1) + 1);
            product.setImage("https://downloader.disk.yandex.ru/preview/");
            product.setCategory("snacks");
            products.add(product);
        }
        String[] dessertNames = {"Chocolate brownies", "Vanilla bean panna cotta",
                "Almond biscotti", "Apple pie", "tiramisu", "Caramel flan"};
        for (int i = 0; i<dessertNames.length; i++){
            Random random = new Random();
            Product product = new Product(dessertNames[i], random.nextInt(15 - 1) + 1);
            product.setImage("https://downloader.disk.yandex.ru/preview/");
            product.setCategory("dessert");
            products.add(product);
        }
        return products;
    }
}
