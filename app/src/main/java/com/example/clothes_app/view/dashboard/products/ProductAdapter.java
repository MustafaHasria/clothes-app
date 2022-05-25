package com.example.clothes_app.view.dashboard.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Product;

import java.util.List;

public class ProductAdapter extends ListAdapter<Product, ProductAdapter.ProductViewHolder> {

    private static final DiffUtil.ItemCallback<Product> DIFF_CALLBACK = new DiffUtil.ItemCallback<Product>() {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return true;
        }
    };
    //region Variables
    List<Product> productList;
    ProductAdapter.OnProductAdapterClickListeners onProductAdapterClickListeners;
    //endregion

    //region Constructor
    public ProductAdapter(List<Product> productList, ProductAdapter.OnProductAdapterClickListeners onProductAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.productList = productList;
        this.onProductAdapterClickListeners = onProductAdapterClickListeners;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_product, parent, false);
        return new ProductAdapter.ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {


    }


    //endregion

    //region Click listeners
    public interface OnProductAdapterClickListeners {


    }
    //endregion

    //region ViewHolder
    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        //region Components

        //endregion

        //region Constructor
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {

            }
        }

        @Override
        public boolean onLongClick(View view) {
            return true;
        }
        //endregion
    }
    //endregion


}
