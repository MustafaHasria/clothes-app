package com.example.clothes_app.view.dashboard.products.addproduct.dialog;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Color;

import java.util.List;

public class ShowColorAdapter extends ListAdapter<Color, ShowColorAdapter.ShowColorViewHolder> {

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
    OnShowColorAdapterClickListeners onShowColorAdapterClickListeners;
    //endregion

    //region Constructor
    public ShowColorAdapter(List<Color> colorList, OnShowColorAdapterClickListeners onShowColorAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.colorList = colorList;
        this.onShowColorAdapterClickListeners = onShowColorAdapterClickListeners;
    }

    @NonNull
    @Override
    public ShowColorAdapter.ShowColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_color, parent, false);
        return new ShowColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowColorAdapter.ShowColorViewHolder holder, int position) {
        Color currentColor = getItem(position);
        holder.itemRecycleShowColorTextViewName.setText(currentColor.getName());
        holder.itemRecyclerShowColorImageViewColor.setImageTintList(ColorStateList.valueOf(Integer.parseInt(currentColor.getColor())));
    }


    //endregion

    //region Click listeners
    public interface OnShowColorAdapterClickListeners {
        void onItemRecycleShowColorCheckBoxCheckedChangeListener(Color color, int position);
    }
    //endregion

    //region ViewHolder
    public class ShowColorViewHolder extends RecyclerView.ViewHolder {

        //region Components
        TextView itemRecycleShowColorTextViewName;
        CheckBox itemRecycleShowColorCheckBox;
        ImageView itemRecyclerShowColorImageViewColor;
        //endregion

        //region Constructor
        public ShowColorViewHolder(@NonNull View itemView) {
            super(itemView);

            //components
            itemRecycleShowColorTextViewName = itemView.findViewById(R.id.item_recycler_show_color_text_view_name);
            itemRecycleShowColorCheckBox = itemView.findViewById(R.id.item_recycler_show_color_check_box);
            itemRecyclerShowColorImageViewColor = itemView.findViewById(R.id.item_recycler_show_color_image_view_color);

            //listeners
            itemRecycleShowColorCheckBox.setOnCheckedChangeListener((compoundButton, b) -> {
                onShowColorAdapterClickListeners
                        .onItemRecycleShowColorCheckBoxCheckedChangeListener
                                (colorList.get(getAdapterPosition()), getAdapterPosition());
            });

        }
        //endregion
    }
    //endregion


}
