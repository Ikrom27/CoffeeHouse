package com.example.coffeehouse.data.data_source;

import com.example.coffeehouse.data.models.User;

public interface UserLocalDataSource {
    User getUser();
    void setUser(User user);
}
