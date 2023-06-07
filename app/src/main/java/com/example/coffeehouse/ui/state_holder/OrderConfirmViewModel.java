package com.example.coffeehouse.ui.state_holder;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeehouse.data.models.Cart;
import com.example.coffeehouse.data.models.OrderItem;
import com.example.coffeehouse.data.models.OrderReceive;
import com.example.coffeehouse.data.models.OrderResponse;
import com.example.coffeehouse.data.repository.CartRepository;
import com.example.coffeehouse.data.repository.OrderRepository;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.CartRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.OrderRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConfirmViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private String TAG = "OrderViewModel";

    public OrderConfirmViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepositoryImpl(application.getApplicationContext());
        this.cartRepository = new CartRepositoryImpl(application.getApplicationContext());
        this.orderRepository = new OrderRepositoryImpl(application.getApplicationContext());
        Log.d(TAG, "ViewModel created");
    }

    public LiveData<OrderResponse> getOrder() {
        return orderRepository.getOrderConfirm();
    }

    public LiveData<List<Cart>> getOrderList(){
        return cartRepository.getCartList();
    }

    public void deleteCompletedOrder(){
        orderRepository.clearConfirmOrder();
    }
    public void push(List<Cart> cartList, double total){
        Log.d(TAG, "pushing");
        List<OrderItem> orderItemList = cartList.stream()
                .map(cart -> new OrderItem(cart.getQuantity(), cart.getProductId()))
                .collect(Collectors.toList());
        orderRepository.pushOrder(new OrderReceive(total,
                userRepository.getUserId(),
                orderItemList));
    }
}
