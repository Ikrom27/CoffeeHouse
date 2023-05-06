package com.example.coffeehouse.ui.state_holder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import com.example.coffeehouse.ui.main.menu.DessertFragment;
import com.example.coffeehouse.ui.main.menu.MenuCoffeeFragment;
import com.example.coffeehouse.ui.main.menu.SnackFragment;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    private final List<Fragment> fragments = new ArrayList<>();

    public MenuViewModel(@NonNull Application application) {
        super(application);
        fragments.add(new MenuCoffeeFragment());
        fragments.add(new SnackFragment());
        fragments.add(new DessertFragment());
    }


    public List<Fragment> getFragments() {
        return fragments;
    }
}

