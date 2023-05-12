package com.example.coffeehouse.data.data_source;

import com.example.coffeehouse.data.models.User;

public interface UserRemoteDataSource {
    void pushUser(User user);
    User fetch(User user);
}
