package com.example.coffeehouse.ui.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.products.list.ProductsRepository;
import com.example.coffeehouse.data.products.list.room.dao.ProductEntity;
import com.example.coffeehouse.data.repository.UserRepository;

import java.util.List;

public class CartViewModel extends ViewModel {
    private ProductsRepository productsRepository;

    public void setProductsRepository(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public void setProduct(String name, String price){
        productsRepository.addProduct(new Product(name, Integer.parseInt(price)));
    }

    public LiveData<List<ProductEntity>> getProductList(){
        return productsRepository.getProductList();
    }
}
