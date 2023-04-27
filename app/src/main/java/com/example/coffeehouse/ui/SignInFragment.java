package com.example.coffeehouse.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coffeehouse.R;

public class SignInFragment extends Fragment {
    private final String TAG = "SignInFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        Bundle bundle = getArguments();
        if (bundle != null){
            Log.d(TAG, "Get bundle");
            EditText v = (EditText) view.findViewById(R.id.et_sign_in_email);
            String email = bundle.getString("email");
            Log.d(TAG, email);
            v.setText(email);
        }
        TextView buttonSignUp = (TextView) view.findViewById(R.id.btn_sign_up);
        buttonSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick handle");
                Navigation.findNavController(view)
                          .navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });

        ImageButton forwardButton = (ImageButton) view.findViewById(R.id.bt_forward);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}