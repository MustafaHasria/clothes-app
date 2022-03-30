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
import com.example.clothes_app.model.entity.Tissue;

import java.util.List;

public class TissueAdapter extends ListAdapter<Tissue, TissueAdapter.TissueViewHolder> {

    private static final DiffUtil.ItemCallback<Tissue> DIFF_CALLBACK = new DiffUtil.ItemCallback<Tissue>() {

        @Override
        public boolean areItemsTheSame(@NonNull Tissue oldItem, @NonNull Tissue newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tissue oldItem, @NonNull Tissue newItem) {
            return oldItem.getName().equals(newItem.getName())
                    && oldItem.getMadeOf().equals(newItem.getMadeOf());
        }
    };

    //region Variables
    List<Tissue> tissueList;
    TissueAdapter.OnTissueAdapterClickListeners onTissueAdapterClickListeners;


    //endregion

    //region Constructor
    public TissueAdapter(List<Tissue> tissueList, TissueAdapter.OnTissueAdapterClickListeners onTissueAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.tissueList = tissueList;
        this.onTissueAdapterClickListeners = onTissueAdapterClickListeners;
    }

    @NonNull
    @Override
    public TissueAdapter.TissueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_tissue, parent, false);
        return new TissueAdapter.TissueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TissueAdapter.TissueViewHolder holder, int position) {
        Tissue currentTissue = getItem(position);
        holder.itemRecyclerTissueTextViewName.setText(currentTissue.getName());
        holder.itemRecyclerTissueTextViewMadeOf.setText(currentTissue.getMadeOf());
    }

    //endregion

    public interface OnTissueAdapterClickListeners {

        void onItemRecyclerTissueCardViewMainContainerClickListener(Tissue tissue, int position);

        void onItemRecyclerTissueImageViewDelete(Tissue tissue, int position);


    }
    //endregion

    //region ViewHolder
    public class TissueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        CardView itemRecyclerTissueCardViewMainContainer;
        TextView itemRecyclerTissueTextViewName;
        TextView itemRecyclerTissueTextViewMadeOf;
        ImageView itemRecyclerTissueImageViewDelete;

        //endregion

        //region Constructor
        public TissueViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerTissueCardViewMainContainer = itemView.findViewById(R.id.item_recycler_tissue_card_view_main_container);
            itemRecyclerTissueTextViewName = itemView.findViewById(R.id.item_recycler_tissue_text_view_name);
            itemRecyclerTissueTextViewMadeOf = itemView.findViewById(R.id.item_recycler_tissue_text_view_made_of);
            itemRecyclerTissueImageViewDelete = itemView.findViewById(R.id.item_recycler_tissue_image_view_delete);

            itemRecyclerTissueCardViewMainContainer.setOnClickListener(this);
            itemRecyclerTissueImageViewDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Tissue tissue = getItem(getAdapterPosition());
            switch (view.getId()) {
                case R.id.item_recycler_tissue_card_view_main_container:
                    onTissueAdapterClickListeners.onItemRecyclerTissueCardViewMainContainerClickListener(tissue, getAdapterPosition());
                    break;
                case R.id.item_recycler_tissue_image_view_delete:
                    onTissueAdapterClickListeners.onItemRecyclerTissueImageViewDelete(tissue, getAdapterPosition());
                    break;
            }

        }

        //endregion
    }
    //endregion

}
