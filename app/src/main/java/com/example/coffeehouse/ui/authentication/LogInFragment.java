package com.example.coffeehouse.ui.authentication;

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

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.LoginViewModel;

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
        edEmail.setText("admin@mail.ru");
        edPassword.setText("Admin2023");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //REGISTER BUTTON
        TextView buttonRegister = view.findViewById(R.id.btn_sign_up);
        buttonRegister.setOnClickListener(view1 -> {
            Log.d(TAG, "buttonLogin handle");
            Navigation.findNavController(view)
                    .navigate(R.id.action_signInFragment_to_signUpFragment);
        });

        //FORWARD BUTTON
        ImageButton btnForward = view.findViewById(R.id.bt_forward);
        btnForward.setOnClickListener(view2 -> {
            loginViewModel.setEmail(edEmail.getText().toString());
            loginViewModel.setPassword(edPassword.getText().toString());
            loginViewModel.getUserByEmail().observe(getViewLifecycleOwner(), user -> {
                if (user != null){
                    Log.d(TAG, "Forward handle");
                    requireActivity().finish();
                }
            });
        });

        //BACKWARD BUTTON
        ImageButton btnBackward = view.findViewById(R.id.bt_back_light);
        btnBackward.setOnClickListener(view12 -> Navigation.findNavController(view12)
                .navigateUp());
    }
}
