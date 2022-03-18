package com.example.clothes_app.view.productextensions.adapter;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Color;

import java.util.List;

public class ColorAdapter extends ListAdapter<Color, ColorAdapter.ColorViewHolder> {

    private static final DiffUtil.ItemCallback<Color> DIFF_CALLBACK = new DiffUtil.ItemCallback<Color>() {

        @Override
        public boolean areItemsTheSame(@NonNull Color oldItem, @NonNull Color newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Color oldItem, @NonNull Color newItem) {
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getColor().equals(newItem.getColor())
                    ;
        }
    };
    //region Variables
    List<Color> colorList;
    OnColorAdapterClickListeners onColorAdapterClickListeners;
    //endregion

    //region Constructor
    public ColorAdapter(List<Color> colorList, OnColorAdapterClickListeners onAccountAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.colorList = colorList;
        this.onColorAdapterClickListeners = onAccountAdapterClickListeners;
    }

    @NonNull
    @Override
    public ColorAdapter.ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_color, parent, false);
        return new ColorAdapter.ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ColorViewHolder holder, int position) {
        Color currentColor = getItem(position);
        holder.itemRecyclerColorTextViewName.setText(currentColor.getName());
        holder.itemRecyclerColorImageButtonColor.setImageTintList(ColorStateList.valueOf(Integer.parseInt(currentColor.getColor())));
    }


    //endregion

    //region Click listeners
    public interface OnColorAdapterClickListeners {
        void onItemRecyclerColorCardViewMainContainerClickListener(Color color, int position);

        void onItemRecyclerColorImageViewDelete(Color color, int position);
    }
    //endregion

    //region ViewHolder
    public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerColorCardViewMainContainer;
        ImageButton itemRecyclerColorImageButtonColor;
        ImageButton itemRecyclerColorImageViewDelete;
        TextView itemRecyclerColorTextViewName;
        //endregion

        //region Constructor
        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerColorCardViewMainContainer = itemView.findViewById(R.id.item_recycler_color_card_view_main_container);
            itemRecyclerColorImageButtonColor = itemView.findViewById(R.id.item_recycler_color_image_button_color);
            itemRecyclerColorImageViewDelete = itemView.findViewById(R.id.item_recycler_color_image_view_delete);
            itemRecyclerColorTextViewName = itemView.findViewById(R.id.item_recycler_color_text_view_name);

            itemRecyclerColorCardViewMainContainer.setOnClickListener(this);
            itemRecyclerColorImageViewDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Color color = getItem(getAdapterPosition());
            switch (view.getId()) {
                case R.id.item_recycler_color_card_view_main_container:
                    onColorAdapterClickListeners.onItemRecyclerColorCardViewMainContainerClickListener(color, getAdapterPosition());
                    break;
                case R.id.item_recycler_color_image_view_delete:
                    onColorAdapterClickListeners.onItemRecyclerColorImageViewDelete(color, getAdapterPosition());
                    break;
            }

        }

        //endregion
    }
    //endregion


}

