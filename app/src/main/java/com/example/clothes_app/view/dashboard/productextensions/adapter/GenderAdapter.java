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
import com.example.clothes_app.model.entity.Gender;

import java.util.List;

public class GenderAdapter extends ListAdapter<Gender, GenderAdapter.GenderViewHolder> {

    private static final DiffUtil.ItemCallback<Gender> DIFF_CALLBACK = new DiffUtil.ItemCallback<Gender>() {

        @Override
        public boolean areItemsTheSame(@NonNull Gender oldItem, @NonNull Gender newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Gender oldItem, @NonNull Gender newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };
    //region Variables
    List<Gender> genderList;
    OnGenderAdapterClickListeners onGenderAdapterClickListeners;
    //endregion

    //region Constructor
    public GenderAdapter(List<Gender> genderList, OnGenderAdapterClickListeners onAccountAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.genderList = genderList;
        this.onGenderAdapterClickListeners = onAccountAdapterClickListeners;
    }

    @NonNull
    @Override
    public GenderAdapter.GenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_gender, parent, false);
        return new GenderAdapter.GenderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenderAdapter.GenderViewHolder holder, int position) {
        Gender currentGender = getItem(position);
        holder.itemRecyclerGenderTextViewName.setText(currentGender.getName());
    }


    //endregion

    //region Click listeners
    public interface OnGenderAdapterClickListeners {
        void onItemRecyclerGenderCardViewMainContainerClickListener(Gender color, int position);

        void onItemRecyclerGenderImageViewDelete(Gender color, int position);
    }
    //endregion

    //region ViewHolder
    public class GenderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerGenderCardViewMainContainer;
        ImageView itemRecyclerGenderImageViewDelete;
        TextView itemRecyclerGenderTextViewName;
        //endregion

        //region Constructor
        public GenderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerGenderCardViewMainContainer = itemView.findViewById(R.id.item_recycler_gender_card_view_main_container);
            itemRecyclerGenderImageViewDelete = itemView.findViewById(R.id.item_recycler_gender_image_view_delete);
            itemRecyclerGenderTextViewName = itemView.findViewById(R.id.item_recycler_gender_text_view_name);

            itemRecyclerGenderCardViewMainContainer.setOnClickListener(this);
            itemRecyclerGenderImageViewDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Gender color = getItem(getAdapterPosition());
            switch (view.getId()) {
                case R.id.item_recycler_gender_card_view_main_container:
                    onGenderAdapterClickListeners.onItemRecyclerGenderCardViewMainContainerClickListener(color, getAdapterPosition());
                    break;
                case R.id.item_recycler_gender_image_view_delete:
                    onGenderAdapterClickListeners.onItemRecyclerGenderImageViewDelete(color, getAdapterPosition());
                    break;
            }

        }

        //endregion
    }
    //endregion


}

