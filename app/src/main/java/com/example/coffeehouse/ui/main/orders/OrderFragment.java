package com.example.coffeehouse.ui.main.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.main.menu.DessertFragment;
import com.example.coffeehouse.ui.main.menu.MenuCoffeeFragment;
import com.example.coffeehouse.ui.main.menu.SnackFragment;
import com.example.coffeehouse.ui.state_holder.adapter.MenuFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private String[] TAB_TITLES;
    private final List<Fragment> FRAGMENTS = new ArrayList<Fragment>() {{
        add(new OrderOnGoingFragment());
        add(new OrderHistoryFragment());
    }};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        TAB_TITLES = new String[]{getString(R.string.on_going), getString(R.string.history)};

        tabLayout = view.findViewById(R.id.tl_menu_tabs);
        viewPager2 = view.findViewById(R.id.vp2_container);
        MenuFragmentStateAdapter adapter = new MenuFragmentStateAdapter(this);
        adapter.setFragments(FRAGMENTS);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(TAB_TITLES[position])).attach();
        return view;
    }
}