package com.example.coffeehouse.data.data_source.user;

import com.example.coffeehouse.data.models.UserResponse;

public interface UserLocalDataSource {
    UserResponse getUser();
    void setUser(UserResponse user);
    void deleteUser();
}
