package com.example.coffeehouse.ui.authentication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.RegisterViewModel;

import java.util.Objects;

public class RegisterFragment extends Fragment {
    private final String TAG = "RegisterFragment";
    private RegisterViewModel registerViewModel;
    private EditText userName;
    private EditText userPhone;
    private EditText userEmail;
    private EditText userPassword;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        userName = view.findViewById(R.id.et_user_name);
        userPhone = view.findViewById(R.id.et_phone_number);
        userEmail = view.findViewById(R.id.et_email);
        userPassword = view.findViewById(R.id.et_password);
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerViewModel.getIsValidName().observe(getViewLifecycleOwner(), validName -> {
            if (!validName) {
                String errorText = requireContext().getString(R.string.name_error);
                userName.setError(errorText);
            }
        });

        registerViewModel.getIsValidPhone().observe(getViewLifecycleOwner(), validPhone -> {
            if (!validPhone) {
                String errorText = requireContext().getString(R.string.phone_error);
                userPhone.setError(errorText);
            }
        });

        registerViewModel.getIsValidEmail().observe(getViewLifecycleOwner(), validEmail -> {
            if (!validEmail) {
                String errorText = requireContext().getString(R.string.email_error);
                userEmail.setError(errorText);
            }
        });

        registerViewModel.getIsValidPassword().observe(getViewLifecycleOwner(), validPassword -> {
            if (!validPassword) {
                String errorText = requireContext().getString(R.string.password_error);
                userPassword.setError(errorText);
            }
        });


        //FORWARD BUTTON
        ImageButton buttonForward = (ImageButton) view.findViewById(R.id.bt_forward_signup);
        EditText email = (EditText) view.findViewById(R.id.et_email);
        buttonForward.setOnClickListener(view1 -> {
            Log.d(TAG, "onClick handle");
            registerViewModel.setUserName(userName.getText().toString());
            registerViewModel.setUserPhone(userPhone.getText().toString());
            registerViewModel.setUserEmail(userEmail.getText().toString());
            registerViewModel.setUserPassword(userPassword.getText().toString());
            if (registerViewModel.registerUser()){
                Navigation.findNavController(view1)
                        .navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });
    }
}
