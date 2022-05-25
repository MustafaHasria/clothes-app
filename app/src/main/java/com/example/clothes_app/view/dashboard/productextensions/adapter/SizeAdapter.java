package com.example.clothes_app.view.dashboard.productextensions.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.view.dashboard.productextensions.ProductExtensionsViewModel;

import java.util.List;

public class SizeAdapter extends ListAdapter<Size, SizeAdapter.SizeViewHolder> {

    private static final DiffUtil.ItemCallback<Size> DIFF_CALLBACK = new DiffUtil.ItemCallback<Size>() {

        @Override
        public boolean areItemsTheSame(@NonNull Size oldItem, @NonNull Size newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Size oldItem, @NonNull Size newItem) {
            return oldItem.getName().equals(newItem.getName())
                    && oldItem.getIdGender() == newItem.getIdGender();
        }
    };
    //region Variables
    List<Size> sizeList;
    OnSizeAdapterClickListeners onSizeAdapterClickListeners;
    ProductExtensionsViewModel productExtensionsViewModel;
    //endregion

    //region Constructor
    public SizeAdapter(List<Size> sizeList, OnSizeAdapterClickListeners onSizeAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.sizeList = sizeList;
        this.onSizeAdapterClickListeners = onSizeAdapterClickListeners;
    }

    @NonNull
    @Override
    public SizeAdapter.SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_size, parent, false);
        return new SizeAdapter.SizeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull SizeAdapter.SizeViewHolder holder, int position) {
        Size currentSize = getItem(position);

        holder.itemRecyclerSizeTextViewName.setText(currentSize.getName());
        holder.itemRecyclerSizeTextViewGender.setText("");
    }

    //endregion

    //region Click listeners
    public interface OnSizeAdapterClickListeners {
        void onItemRecyclerSizeCardViewMainContainerClickListener(Size size, int position);

        void onItemRecyclerSizeImageViewDelete(Size size, int position);
    }
    //endregion

    //region ViewHolder
    public class SizeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerSizeCardViewMainContainer;
        ImageView itemRecyclerSizeImageViewDelete;
        TextView itemRecyclerSizeTextViewName;
        TextView itemRecyclerSizeTextViewGender;
        //endregion

        //region Constructor
        public SizeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerSizeCardViewMainContainer = itemView.findViewById(R.id.item_recycler_size_card_view_main_container);
            itemRecyclerSizeImageViewDelete = itemView.findViewById(R.id.item_recycler_size_image_view_delete);
            itemRecyclerSizeTextViewName = itemView.findViewById(R.id.item_recycler_size_text_view_name);
            itemRecyclerSizeTextViewGender = itemView.findViewById(R.id.item_recycler_size_text_view_gender);

            itemRecyclerSizeCardViewMainContainer.setOnClickListener(this);
            itemRecyclerSizeImageViewDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Size size = getItem(getAdapterPosition());
            switch (view.getId()) {
                case R.id.item_recycler_size_card_view_main_container:
                    onSizeAdapterClickListeners.onItemRecyclerSizeCardViewMainContainerClickListener(size, getAdapterPosition());
                    break;
                case R.id.item_recycler_size_image_view_delete:
                    onSizeAdapterClickListeners.onItemRecyclerSizeImageViewDelete(size, getAdapterPosition());
                    break;
            }

        }

        //endregion
    }
    //endregion


}

