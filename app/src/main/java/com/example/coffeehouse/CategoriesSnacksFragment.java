package com.example.coffeehouse;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;


public class CategoriesSnacksFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories_snaks, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        RecyclerView recyclerView = requireActivity().findViewById(R.id.rv_snacks);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        //DELETE
        String[] productsNames = {"Donut", "Cake", "Kurasan", "Sandwich"};
        ProductsList products = new ProductsList(productsNames);

        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(products.createProducts(200));

        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && e.getAction() == MotionEvent.ACTION_UP) {
                    TextView productName = (TextView) childView.findViewById(R.id.tv_categories_snacks_name);
                    int position = rv.getChildAdapterPosition(childView);
                    String message = productName.getText() + " clicked at position " + position;
                    Log.d("RecyclerView", message);
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    public static class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
        private final List<Product> products;

        public RecycleViewAdapter(List<Product> products){
            this.products = products;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories_snaks, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Product item = products.get(position);
            holder.productImage.setImageResource(R.drawable.ic_snacks);
            holder.productName.setText(item.getName());
            String price = Integer.toString(item.getPrice());
            holder.productPrice.setText("$" + price + ".00");
        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView productImage;
            public TextView productName;
            public TextView productPrice;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                productImage = itemView.findViewById(R.id.iv_categories_snacks_image);
                productName = itemView.findViewById(R.id.tv_categories_snacks_name);
                productPrice = itemView.findViewById(R.id.tv_categories_snacks_price);
            }
        }
    }
}