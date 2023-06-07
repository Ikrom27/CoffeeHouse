package com.example.coffeehouse.ui.main.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.main.cart.ConfirmOrderFragment;
import com.example.coffeehouse.ui.main.OrderCompleteFragment;
import com.example.coffeehouse.ui.main.menu.categories.CoffeeFragment;
import com.example.coffeehouse.ui.main.menu.categories.DessertFragment;
import com.example.coffeehouse.ui.main.menu.categories.SnackFragment;
import com.example.coffeehouse.ui.state_holder.MenuViewModel;
import com.example.coffeehouse.ui.state_holder.OrderConfirmViewModel;
import com.example.coffeehouse.ui.state_holder.adapter.MenuFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment{
    private final String TAG = "CategoriesFragment";
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private TextView tvUserName;
    private TextView tvCartNum;
    private MenuViewModel menuViewModel;
    private OrderConfirmViewModel orderConfirmViewModel;
    private MenuFragmentStateAdapter adapter;

    private String[] TAB_TITLES;
    private final List<Fragment> FRAGMENTS = new ArrayList<Fragment>() {{
        add(new CoffeeFragment());
        add(new SnackFragment());
        add(new DessertFragment());
    }};



    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        //INIT
        this.orderConfirmViewModel = new ViewModelProvider(requireActivity()).get(OrderConfirmViewModel.class);
        this.menuViewModel = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        this.tabLayout = view.findViewById(R.id.tl_menu_tabs);
        this.viewPager2 = view.findViewById(R.id.vp2_container);
        this.adapter = new MenuFragmentStateAdapter(this);
        this.tvUserName = view.findViewById(R.id.tv_profile_name);
        this.tvCartNum = view.findViewById(R.id.tv_cart_num);
        this.TAB_TITLES = new String[]{getString(R.string.coffee),
                                        getString(R.string.snacks),
                                        getString(R.string.dessert)};

        //SET TABS
        adapter.setFragments(FRAGMENTS);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(TAB_TITLES[position])).attach();


        //SHOW USER NAME
        menuViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                tvUserName.setText(user.getName());
            }
            else {
                Log.d(TAG, "start authentication");
                Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                        .navigate(R.id.action_mainFragment_to_authenticationActivity);
            }
        });

        menuViewModel.getCartList().observe(getViewLifecycleOwner(), carts -> {
            if (carts != null){
                if (carts.size() > 0){
                    if (carts.size() > 99){
                        tvCartNum.setText("99+");
                        tvCartNum.setTextSize(10);
                    }
                    else{
                        tvCartNum.setText(Integer.toString(carts.size()));
                        tvCartNum.setTextSize(14);
                    }
                    tvCartNum.setVisibility(View.VISIBLE);
                }
                else{
                    tvCartNum.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //CART BUTTON HANDLE
        ImageButton cartButton = view.findViewById(R.id.bt_buy_light);
        cartButton.setOnClickListener(view1 -> {
            Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                    .navigate(R.id.action_mainFragment_to_cartFragment);
            Log.d(TAG, "Cart button handle");
        });

        //SHOW ORDER COMPLETE
        orderConfirmViewModel.getOrder().observe(getViewLifecycleOwner(), order -> {
            if (order != null){
                OrderCompleteFragment fragment = new OrderCompleteFragment();
                Bundle args = new Bundle();
                args.putDouble("total", order.getTotal());
                args.putInt("id", order.getOrderID());
                fragment.setArguments(args);
                fragment.show(getChildFragmentManager(), ConfirmOrderFragment.TAG);
                orderConfirmViewModel.deleteCompletedOrder();
            }
        });
    }
}
