package com.example.coffeehouse.ui.state_holder;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.repository.ProductRepository;
import com.example.coffeehouse.data.repository.impl.CartRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

public class DetailsViewModel extends AndroidViewModel {
    private final CartRepository cartRepository;
    private ProductRepository productRepository;
    private final String TAG = "DetailsViewModel";

    public DetailsViewModel(@NonNull Application application){
        super(application);
        cartRepository = new CartRepositoryImpl(application);
        productRepository = new ProductRepositoryImpl(application);
    }

    public void toCart(String name, double price, String imageUrl, int id){
        Log.d(TAG, "ID = " + id);
        LiveData<Cart> productOrder = cartRepository.getOrderByID(id);
        if (productOrder.getValue() == null){
            Log.d(TAG, "create new order");
            Cart order = new Cart(name, price, imageUrl,1, id);
            cartRepository.addToCart(order);
            Log.d(TAG, "increase order");
            productOrder.getValue().increaseOrderQuantity();
            cartRepository.update(order);
        }
        else{
            Log.d(TAG, "increase order");
            productOrder.increaseOrderQuantity();
            cartRepository.addToCart(productOrder);
        }
    }
}
