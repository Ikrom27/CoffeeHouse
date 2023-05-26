package com.example.coffeehouse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coffeehouse.ui.state_holder.CartViewModel;
import com.example.coffeehouse.ui.state_holder.WebViewModel;

public class BlankFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        WebViewModel viewModel = new ViewModelProvider(this).get(WebViewModel.class);
        TextView getF = view.findViewById(R.id.textView6);
        TextView postF = view.findViewById(R.id.textView12);
        TextView getS = view.findViewById(R.id.textView14);
        viewModel.getPost().observe(getViewLifecycleOwner(), post -> {
            getF.setText(post.getTitle());
        });
        viewModel.pushPost("bla bla", "mega bla").observe(getViewLifecycleOwner(), post -> {
            postF.setText(post.getTitle());
        });
        viewModel.getAllPosts().observe(getViewLifecycleOwner(), post -> {
            getS.setText(post.get(1).getTitle());
        });
        return view;

    }
}