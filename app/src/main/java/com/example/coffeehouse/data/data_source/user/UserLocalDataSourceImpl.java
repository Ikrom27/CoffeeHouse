package com.example.coffeehouse.data.data_source.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.models.UserResponse;
import com.google.gson.Gson;

public class UserLocalDataSourceImpl implements UserLocalDataSource {
    private final SharedPreferences sharedPreferences;
    private String SHARED_PREFERENCES_TITLE = "com.example.coffeehouse.user";
    private String USER_KEY = "user";
    public UserLocalDataSourceImpl(Context context){
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_TITLE,
                                                              Context.MODE_PRIVATE);
    }

    @Override
    public UserResponse getUser() {
        String userJson = sharedPreferences.getString(USER_KEY, "");
        if (!TextUtils.isEmpty(userJson)){
            return new Gson().fromJson(userJson, UserResponse.class);
        }
        return null;
    }

    @Override
    public void setUser(UserResponse user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_KEY, new Gson().toJson(user));
        editor.apply();
    }

    public void deleteUser(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(USER_KEY);
        editor.apply();
    }
}
