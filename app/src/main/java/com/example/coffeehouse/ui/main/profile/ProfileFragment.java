package com.example.coffeehouse.ui.main.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.ProfileViewModel;


public class ProfileFragment extends Fragment {
    private TextView tvProfileName;
    private TextView tvProfilePhone;
    private TextView tvProfileEmail;
    private Button btnExit;
    private ProfileViewModel profileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnExit = view.findViewById(R.id.btn_exit);

        tvProfileName = view.findViewById(R.id.tv_profile_name);
        tvProfilePhone = view.findViewById(R.id.tv_profile_phone);
        tvProfileEmail = view.findViewById(R.id.tv_profile_email);

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            tvProfileName.setText(user.getName());
            tvProfilePhone.setText(user.getPhoneNumber());
            tvProfileEmail.setText(user.getEmail());
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnExit.setOnClickListener(view1 -> {
            profileViewModel.exitUser();
            Toast.makeText(getContext(), "Profile exit", Toast.LENGTH_SHORT).show();
            requireActivity().finish();
        });
    }
}