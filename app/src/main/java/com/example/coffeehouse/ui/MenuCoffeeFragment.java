package com.example.coffeehouse.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coffeehouse.data.models.Coffee;
import com.example.coffeehouse.R;
import com.example.coffeehouse.ui.view_model.MenuCoffeeViewModel;

import java.util.List;


public class MenuCoffeeFragment extends Fragment {
    private final String TAG = "CategoriesCoffeeFragment";
    private RecyclerView recyclerView;
    private CoffeeAdapter coffeeAdapter;
    private MenuCoffeeViewModel coffeeViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_menu_coffee, container,false);

        recyclerView = view.findViewById(R.id.rv_coffee);
        coffeeAdapter = new CoffeeAdapter(coffeeViewModel);
        recyclerView.setAdapter(coffeeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        coffeeViewModel = new ViewModelProvider(this).get(MenuCoffeeViewModel.class);
        coffeeViewModel.getCoffeeList().observe(getViewLifecycleOwner(), coffees -> {
            coffeeAdapter.onItemClickListener((coffee, position) -> {
                Log.d(TAG, "Item click handle");
                Bundle bundle = new Bundle();
                bundle.putString("coffee_name", coffee.getName());
                bundle.putString("coffee_price", Double.toString(coffee.getPrice()));
                Navigation.findNavController(requireActivity(), R.id.fragment_main_menu)
                        .navigate(R.id.action_mainFragment_to_coffeeConfigFragment, bundle);
            });

            coffeeAdapter.setCoffeeList(coffees);
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>{
        private List<Coffee> coffeeList;
        private OnCoffeeClickListener mListener;

        private MenuCoffeeViewModel viewModel;

        public CoffeeAdapter(MenuCoffeeViewModel viewModel){
            this.viewModel = viewModel;
        }

        @NonNull
        @Override
        public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_categories_coffee, parent, false);
            return new CoffeeViewHolder(view);
        }



        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
            Coffee coffee = coffeeList.get(position);
            holder.tvCoffeeName.setText(coffee.getName());
            holder.tvCoffeePrice.setText(Double.toString(coffee.getPrice()));
            holder.itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    mListener.onClick(coffee, position);
                }
            });
        }

        public void onItemClickListener(OnCoffeeClickListener listener){
            mListener = listener;
        }

        @Override
        public int getItemCount() {
            return coffeeList.size();
        }

        @SuppressLint("NotifyDataSetChanged")
        public void setCoffeeList(List<Coffee> coffeeList) {
            this.coffeeList = coffeeList;
            notifyDataSetChanged();
        }

        class CoffeeViewHolder extends RecyclerView.ViewHolder {
            public TextView tvCoffeeName;
            public TextView tvCoffeePrice;

            public CoffeeViewHolder(@NonNull View itemView) {
                super(itemView);
                tvCoffeeName = itemView.findViewById(R.id.tv_product_name);
                tvCoffeePrice = itemView.findViewById(R.id.tv_product_price);
            }
        }
    }
    public interface OnCoffeeClickListener{
        void onClick(Coffee coffee, int position);
    }
}

