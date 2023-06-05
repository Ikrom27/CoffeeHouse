package com.example.coffeehouse.ui.state_holder;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.repository.ProductRepository;
import com.example.coffeehouse.data.repository.CartRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.ProductRepositoryImpl;

import java.util.concurrent.atomic.AtomicBoolean;

public class DetailsViewModel extends AndroidViewModel {
    private final CartRepository cartRepository;
    private ProductRepository productRepository;
    private final String TAG = "DetailsViewModel";

    public DetailsViewModel(@NonNull Application application){
        super(application);
        cartRepository = new CartRepositoryImpl(application);
        productRepository = new ProductRepositoryImpl(application);
    }

    public LiveData<Cart> getOrderByID(int id){
        return cartRepository.getOrderByID(id);
    }

    public void update(Cart cart){
        cartRepository.update(cart);
    }

    public void toCart(String name, double price, String imageUrl, int id){
        LiveData<Cart> cartLiveData = cartRepository.getOrderByID(id);
        cartLiveData.observeForever(new Observer<Cart>() {
            @Override
            public void onChanged(Cart productOrder) {
                cartLiveData.removeObserver(this);
                if (productOrder == null){
                    Log.d(TAG, "create new order");
                    productOrder = new Cart(1, id, name, price, imageUrl);
                    cartRepository.addToCart(productOrder);
                }
                else{
                    Log.d(TAG, "increase order");
                    productOrder.increaseOrderQuantity();
                    productOrder.setProductPrice(price * productOrder.getQuantity());
                    cartRepository.update(productOrder);
                }
            }
        });
    }
}
