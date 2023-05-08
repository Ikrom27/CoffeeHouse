package com.example.coffeehouse.ui.main.menu.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.SnacksViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.SnacksAdapter;


public class SnackFragment extends Fragment {
    private SnacksViewModel snacksViewModel;
    private RecyclerView recyclerView;
    private SnacksAdapter snacksAdapter;
    private String TAG = "DessertFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_menu_coffee, container,false);
        recyclerView = view.findViewById(R.id.rv_coffee);
        this.snacksViewModel = new ViewModelProvider(this).get(SnacksViewModel.class);

        snacksAdapter = new SnacksAdapter();
        snacksAdapter.setSnackList(snacksViewModel.getSnackList().getValue());
        recyclerView.setAdapter(snacksAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        snacksViewModel.getSnackList().observe(getViewLifecycleOwner(), snacks -> snacksAdapter.setSnackList(snacks));

        snacksAdapter.onItemClickListener((snack, position) -> {
            Log.d(TAG, "Item click handle");
            Bundle bundle = new Bundle();
            bundle.putString("product_name", snack.getName());
            bundle.putDouble("product_price", snack.getPrice());
            bundle.putString("product_type", "Snack");
            bundle.putString("product_image", snack.getImage());
            Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                    .navigate(R.id.action_mainFragment_to_coffeeConfigFragment, bundle);
        });
        return view;
    }
}