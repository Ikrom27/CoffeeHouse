package com.example.coffeehouse.data.data_source;

import com.example.coffeehouse.data.models.User;

import java.util.List;

public class UserRemoteDataSourceImpl implements UserRemoteDataSource{

    @Override
    public User fetchUser(String userId) throws Exception {
        return null;
    }

    @Override
    public void pushUser(User user) throws Exception {

    }

    @Override
    public List<User> fetchUsers() throws Exception {
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        return null;
    }

    @Override
    public User updateUser(User user) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws Exception {

    }
}
