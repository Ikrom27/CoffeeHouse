package com.example.coffeehouse.ui.main.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.state_holder.MenuViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.MenuFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MenuFragment extends Fragment {
    private final String TAG = "CategoriesFragment";
    private final Fragment coffeeFragment = new MenuCoffeeFragment();

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        tabLayout = view.findViewById(R.id.tl_menu_tabs);
        viewPager2 = view.findViewById(R.id.vp2_container);

        MenuFragmentStateAdapter adapter = new MenuFragmentStateAdapter(this);
        MenuViewModel viewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        adapter.setFragments(viewModel.getFragments());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(getString(R.string.coffee));
                            break;
                        case 1:
                            tab.setText(getString(R.string.snacks));
                            break;
                        case 2:
                            tab.setText(getString(R.string.dessert));
                            break;
                    }
                }).attach();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton cartButton = view.findViewById(R.id.bt_buy_light);
        cartButton.setOnClickListener(view1 -> Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                .navigate(R.id.action_mainFragment_to_cartFragment));
    }
}