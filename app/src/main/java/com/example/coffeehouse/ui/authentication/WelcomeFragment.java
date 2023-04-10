package com.example.coffeehouse.ui.authentication;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.coffeehouse.R;


public class WelcomeFragment extends Fragment {
    private final String TAG = "WelcomeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.bt_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick handle");
                findNavController(view).navigate(R.id.action_welcomeFragment_to_signInFragment);
            }
        });
        return view;
    }
}