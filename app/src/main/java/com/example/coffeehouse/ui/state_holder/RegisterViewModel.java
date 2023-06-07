package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeehouse.data.models.User;
import com.example.coffeehouse.data.repository.UserRepository;
import com.example.coffeehouse.data.repository.impl.UserRepositoryImpl;

import java.util.Objects;

public class RegisterViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> isValidName;
    private MutableLiveData<Boolean> isValidPhone;
    private MutableLiveData<Boolean> isValidEmail;
    private MutableLiveData<Boolean> isValidPassword;
    private MutableLiveData<Boolean> isValidConfirm;
    private final String VALID_NAME = "[A-Z][a-z]+";
    private final String VALID_PHONE = "^\\+\\d{10,15}$";
    private final String VALID_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final String VALID_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";


    public RegisterViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepositoryImpl(application);
        user = new MutableLiveData<>(new User());
        isValidName = new MutableLiveData<>(true);
        isValidPhone = new MutableLiveData<>(true);
        isValidEmail = new MutableLiveData<>(true);
        isValidPassword = new MutableLiveData<>(true);
        isValidConfirm = new MutableLiveData<>(true);
    }

    public void setUserName(String userName){
        checkValidName(userName);
        if (Boolean.TRUE.equals(getIsValidName().getValue())){
            user.getValue().setName(userName);
        }
    }

    public void setUserPhone(String userPhone){
        checkValidPhone(userPhone);
        if (Boolean.TRUE.equals(getIsValidPhone().getValue())){
            user.getValue().setPhoneNumber(userPhone);
        }
    }

    public void setUserEmail(String userEmail){
        checkValidEmail(userEmail);
        if (Boolean.TRUE.equals(getIsValidEmail().getValue())) {
            user.getValue().setEmail(userEmail);
        }
    }

    public void setUserPassword(String password){
        checkValidPassword(password);
        if(Boolean.TRUE.equals(getIsValidPassword().getValue())){
            user.getValue().setPassword(password);
        }
    }

    public MutableLiveData<Integer> getRequestState(){
        return userRepository.getRequestState();
    }

    public void setPasswordConfirm(String password){
        checkConfirmPassword(password);
    }
    public boolean registerUser(){
        if (Boolean.TRUE.equals(isValidName.getValue()) &&
            Boolean.TRUE.equals(isValidPhone.getValue()) &&
            Boolean.TRUE.equals(isValidEmail.getValue()) &&
            Boolean.TRUE.equals(isValidPassword.getValue()) &&
            Boolean.TRUE.equals(isValidConfirm.getValue())){
            userRepository.registerUser(user.getValue());
            return true;
        }
        return false;
    }

    private void checkValidName(String name) {
        getIsValidName().setValue(name.matches(VALID_NAME));
    }

    private void checkValidPhone(String phone) {
        getIsValidPhone().setValue(phone.matches(VALID_PHONE));
    }

    private void checkValidEmail(String email) {
        getIsValidEmail().setValue(email
                .matches(VALID_EMAIL));
    }

    private void checkValidPassword(String password) {
        getIsValidPassword().setValue(password
                .matches(VALID_PASSWORD));
    }

    private void checkConfirmPassword(String password){
        getIsValidConfirm().setValue(Objects.equals(password, user.getValue().getPassword()));
    }

    public MutableLiveData<Boolean> getIsValidName() {
        return isValidName;
    }

    public MutableLiveData<Boolean> getIsValidPhone() {
        return isValidPhone;
    }

    public MutableLiveData<Boolean> getIsValidEmail() {
        return isValidEmail;
    }

    public MutableLiveData<Boolean> getIsValidPassword() {
        return isValidPassword;
    }
    public MutableLiveData<Boolean> getIsValidConfirm() {
        return isValidConfirm;
    }
}
