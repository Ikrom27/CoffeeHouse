package com.example.coffeehouse.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;


import com.example.coffeehouse.data.models.User;

public class UserRepository {
    private final SharedPreferences sharedPreferences;
    private String SHARED_PREFERENCES_TITLE = "com.example.myapp.COFFEE_HOUSE";
    private String USER_KEY = "user";

    public UserRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_TITLE,
                                                         Context.MODE_PRIVATE);
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_KEY, new Gson().toJson(user));
        editor.apply();
    }

    public User getUser() {
        String userJson = sharedPreferences.getString(USER_KEY, "");
        if (!TextUtils.isEmpty(userJson)) {
            return new Gson().fromJson(userJson, User.class);
        }
        return null;
    }
}
