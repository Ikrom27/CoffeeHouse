package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.Product;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final CartRepositoryImpl cartRepositoryImpl;
    private final ProductRepositoryImpl productRepository;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.cartRepositoryImpl = new CartRepositoryImpl(application.getApplicationContext());
        this.productRepository = new ProductRepositoryImpl(application.getApplicationContext());
    }

    public void addToCart(String name, float price, String type, String productImage){
        Cart cart = new Cart(name, price, type);
        cart.setImagePath(productImage);
        cartRepositoryImpl.addToCart(cart);
    }

    public Product getCoffeeByName(String name){
        return productRepository.getCoffeeByName(name).getValue();
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepositoryImpl.getCartList();
    }

    public LiveData<Integer> getTotalPrice(){
        return cartRepositoryImpl.getTotalPrice();
    }

    public void clear(){
        cartRepositoryImpl.clear();
    }
}
