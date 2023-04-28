package com.example.coffeehouse.data.products.list;

import android.content.Context;

import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public class ProductDataSource implements ProductLocalDataSource {
    private Context context;

    public ProductDataSource(Context context){
        this.context = context;
    }

    @Override
    public List<ProductEntity> loadAllProducts() {
        return null;
    }
}
