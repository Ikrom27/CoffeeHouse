package com.example.coffeehouse.data.models;

public class UserRequest {
    private String email;
    private String password;

    public UserRequest(String email, String password){
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}