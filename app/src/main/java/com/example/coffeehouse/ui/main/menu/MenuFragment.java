package com.example.coffeehouse.ui.main.menu;

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
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.main.menu.categories.CoffeeFragment;
import com.example.coffeehouse.ui.main.menu.categories.DessertFragment;
import com.example.coffeehouse.ui.main.menu.categories.SnackFragment;
import com.example.coffeehouse.ui.state_holder.MenuViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.MenuFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private final String TAG = "CategoriesFragment";

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private TextView tvUserName;
    private MenuViewModel menuViewModel;

    private String[] TAB_TITLES;
    private final List<Fragment> FRAGMENTS = new ArrayList<Fragment>() {{
        add(new CoffeeFragment());
        add(new SnackFragment());
        add(new DessertFragment());
    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        TAB_TITLES = new String[]{getString(R.string.coffee), getString(R.string.snacks), getString(R.string.dessert)};

        //SET TABS
        tabLayout = view.findViewById(R.id.tl_menu_tabs);
        viewPager2 = view.findViewById(R.id.vp2_container);
        MenuFragmentStateAdapter adapter = new MenuFragmentStateAdapter(this);
        adapter.setFragments(FRAGMENTS);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        //SET PROFILE NAME
        tvUserName = view.findViewById(R.id.tv_profile_name);
        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        menuViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            if (user == null){
                requireActivity().finish();
            }
            else{
                tvUserName.setText(user.getName());
            }
        });

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
