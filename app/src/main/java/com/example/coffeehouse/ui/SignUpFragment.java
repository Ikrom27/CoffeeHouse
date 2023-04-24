package com.example.coffeehouse.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.coffeehouse.R;

public class SignUpFragment extends Fragment {
    private final String TAG = "SignUpFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ImageButton buttonForward = (ImageButton) view.findViewById(R.id.bt_forward_signup);
        EditText email = (EditText) view.findViewById(R.id.et_sign_up_email);
        buttonForward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick handle");
                Bundle bundle = new Bundle();
                Log.d(TAG, email.getText().toString());
                bundle.putString("email", email.getText().toString());
                Navigation.findNavController(view)
                        .navigate(R.id.action_signUpFragment_to_signInFragment, bundle);
            }
        });
        return view;
    }
}
