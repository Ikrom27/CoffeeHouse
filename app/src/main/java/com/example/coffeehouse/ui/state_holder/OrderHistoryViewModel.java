package com.example.coffeehouse.ui.state_holder;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.OrderHistoryResponse;
import com.example.coffeehouse.data.repository.OrderRepository;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.OrderRepositoryImpl;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.List;

public class OrderHistoryViewModel extends AndroidViewModel {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public OrderHistoryViewModel(@NonNull Application application) {
        super(application);
        orderRepository = new OrderRepositoryImpl(application);
        userRepository = new UserRepositoryImpl(application);
    }

    public LiveData<List<OrderHistoryResponse>> getOrderHistory(boolean isReady){
        return orderRepository.getUserOrders(isReady, userRepository.getUserId());
    }
}
