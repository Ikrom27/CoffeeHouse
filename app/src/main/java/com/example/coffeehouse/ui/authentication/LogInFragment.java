package com.example.coffeehouse.ui.authentication;

import android.content.Intent;
import android.os.Bundle;

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
import com.example.coffeehouse.data.products.remote.repository.UserRepository;
import com.example.coffeehouse.ui.main.MainActivity;
import com.example.coffeehouse.ui.state_holder.LoginViewModel;

public class LogInFragment extends Fragment {
    private final String TAG = "SignInFragment";
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserRepository userRepository = new UserRepository(requireActivity());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setUserRepository(userRepository);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText edEmail = view.findViewById(R.id.edit_text_email);
        EditText edPassword = view.findViewById(R.id.edit_text_password);

        edEmail.setText(loginViewModel.getEmail());
        edPassword.setText(loginViewModel.getPassword());

        ImageButton forwardButton = view.findViewById(R.id.bt_forward);
        forwardButton.setOnClickListener(view1 -> {
            String email = edEmail.getText().toString();
            String password = edPassword.getText().toString();

            if (email.equals("") | password.equals("")){
                return;
            }
            Log.d(TAG, email + " " + password);
            loginViewModel.setUser(email, password);

            Intent intent = new Intent(requireActivity(), MainActivity.class);
            startActivity(intent);
        });

        TextView buttonLogin = view.findViewById(R.id.btn_sign_up);
        buttonLogin.setOnClickListener(view12 -> {
            Log.d(TAG, "onClick handle");
            Navigation.findNavController(view12)
                    .navigate(R.id.action_signInFragment_to_signUpFragment);
        });
        return view;
    }
}