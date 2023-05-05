package com.example.coffeehouse.data.data_source;

import com.example.coffeehouse.data.models.User;

import java.util.List;

public interface UserRemoteDataSource {
    User fetchUser(String userId) throws Exception;
    void pushUser(User user) throws Exception;
    List<User> fetchUsers() throws Exception;
    User createUser(User user) throws Exception;
    User updateUser(User user) throws Exception;
    void deleteUser(String userId) throws Exception;
}

