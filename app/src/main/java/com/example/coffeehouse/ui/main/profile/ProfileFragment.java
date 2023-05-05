package com.example.coffeehouse.ui.main.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeehouse.data.models.ProfileSettings;
import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.UserSettingsViewModel;


public class ProfileFragment extends Fragment {
    private UserSettingsViewModel userSettingsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userSettingsViewModel.syncSettings();
        return view;
    }
}