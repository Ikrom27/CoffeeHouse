package com.example.coffeehouse.data.data_source;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Dessert;
import com.example.coffeehouse.data.models.Snack;

import java.util.List;

public interface RetrofitProductDataSource {
    void fetch();
    List<Coffee> getCoffees();
    List<Snack> getSnacks();
    List<Dessert> getDesserts();
}
