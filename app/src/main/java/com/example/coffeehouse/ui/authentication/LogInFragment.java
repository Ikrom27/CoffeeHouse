package com.example.coffeehouse.ui.authentication;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.main.MainActivity;
import com.example.coffeehouse.ui.state_holder.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;

public class LogInFragment extends Fragment {
    private final String TAG = "SignInFragment";
    private LoginViewModel loginViewModel;
    private EditText edEmail;
    private EditText edPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edEmail = view.findViewById(R.id.edit_text_email);
        edPassword = view.findViewById(R.id.et_password);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView buttonLogin = view.findViewById(R.id.btn_sign_up);
        buttonLogin.setOnClickListener(view1 -> {
            Log.d(TAG, "buttonLogin handle");
            Navigation.findNavController(view)
                    .navigate(R.id.action_signInFragment_to_signUpFragment);
        });

        ImageButton btnForward = view.findViewById(R.id.bt_forward);
        btnForward.setOnClickListener(view2 -> {
            loginViewModel.setEmail(edEmail.getText().toString());
            loginViewModel.setPassword(edPassword.getText().toString());
            if (loginViewModel.toLogin()){
                Log.d(TAG, "forward handle");
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_mainActivity);
            }
            else {
                String wrongPassword = requireContext().getString(R.string.wrong_password);
                edPassword.setError(wrongPassword);
            }
        });
    }
}