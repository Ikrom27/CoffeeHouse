package com.example.coffeehouse.ui.authentication;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.main.MainActivity;
import com.example.coffeehouse.ui.state_holder.WelcomeViewModel;


public class WelcomeFragment extends Fragment {
    private final String TAG = "WelcomeFragment";
    private WelcomeViewModel welcomeViewModel;
    private AnimationDrawable coffeeAnimation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        ImageView rocketImage = (ImageView) view.findViewById(R.id.imageView2);
        rocketImage.setBackgroundResource(R.drawable.image_animation);
        coffeeAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeAnimation.start();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        welcomeViewModel = new ViewModelProvider(this).get(WelcomeViewModel.class);
        welcomeViewModel.getLocalUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null){
                findNavController(view).navigate(R.id.action_welcomeFragment_to_mainActivity);
            }
        });
        ImageButton button = (ImageButton) view.findViewById(R.id.bt_forward);
        button.setOnClickListener(view1 -> {
            Log.d(TAG, "onClick handle");
            findNavController(view1).navigate(R.id.action_welcomeFragment_to_signInFragment);
        });
    }
}