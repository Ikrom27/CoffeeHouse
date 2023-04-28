package com.example.coffeehouse.data.products.list.room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.products.list.ProductLocalDataSource;
import com.example.coffeehouse.data.products.list.room.dao.ProductDao;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;

import java.util.List;

public class RoomProductDataSource implements ProductLocalDataSource {
    private ProductDao productDao;

    public RoomProductDataSource(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public LiveData<List<ProductEntity>> loadAllProducts() {
        return productDao.loadAllProducts();
    }

    @SuppressLint("StaticFieldLeak")
    public void addProduct(Product product){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                ProductEntity entity = new ProductEntity(product.getName(), product.getPrice());
                productDao.insert(entity);
                return null;
            }
        }.execute();
    }
}
