package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.data_source.orders.retrofit.OrderReceive;
import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.repository.OrderRepository;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.OrderRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CartViewModel extends AndroidViewModel {
    private final CartRepositoryImpl cartRepositoryImpl;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public CartViewModel(@NonNull Application application) {
        super(application);
        this.cartRepositoryImpl = new CartRepositoryImpl(application.getApplicationContext());
        this.orderRepository = new OrderRepositoryImpl(application.getApplicationContext());
        this.userRepository = new UserRepositoryImpl(application.getApplicationContext());
    }

    public LiveData<List<Cart>> getCartList(){
        return cartRepositoryImpl.getCartList();
    }

    public LiveData<Integer> getTotalPrice(){
        return cartRepositoryImpl.getTotalPrice();
    }
    public void push(List<Cart> cartList, double total){
        List<OrderItem> orderItemList = cartList.stream()
                .map(cart -> new OrderItem(cart.getQuantity(), cart.getProductId()))
                .collect(Collectors.toList());
        orderRepository.pushOrder(new OrderReceive(total,
                userRepository.getLocalUser().getValue().getId(),
                orderItemList));
    }

    public void clear(){
        cartRepositoryImpl.clear();
    }
}
