package com.example.clothes_app.view.dashboard.products.addproduct;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.File;

import java.util.List;

public class AddAndEditImagesAdapter extends RecyclerView.Adapter<AddAndEditImagesAdapter.AddAndEditImagesViewHolder>{

    //region Variables
    List<File> fileList;
    OnAddAndEditImagesAdapterClickListeners onAddAndEditImagesAdapterClickListeners;
    //endregion

    //region Constructor

    public AddAndEditImagesAdapter(List<File> fileList, OnAddAndEditImagesAdapterClickListeners onAddAndEditImagesAdapterClickListeners) {
        this.fileList = fileList;
        this.onAddAndEditImagesAdapterClickListeners = onAddAndEditImagesAdapterClickListeners;
    }

    //endregion
    
    //region Adapter
    @NonNull
    @Override
    public AddAndEditImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_images_product, parent, false);
        return new AddAndEditImagesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddAndEditImagesViewHolder holder, int position) {
        File currentFile = fileList.get(position);
        holder.itemRecyclerImagesProductImageView.setImageBitmap(BitmapFactory
                .decodeByteArray(currentFile.getPicture(), 0, currentFile.getPicture().length));
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public void refreshData(List<File> fileList){
        this.fileList = fileList;
        notifyDataSetChanged();
    }

    public void addData(List<File> fileList){
        this.fileList.addAll(fileList);
        notifyDataSetChanged();
    }


    //endregion

    //region Click listeners
    public interface OnAddAndEditImagesAdapterClickListeners {
        void onItemRecyclerImagesProductImageButtonDelete(File file, int position);
    }
    //endregion

    //region ViewHolder
    public class AddAndEditImagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //region Components
        ImageButton itemRecyclerImagesProductImageButtonDelete;
        ImageView itemRecyclerImagesProductImageView;
        //endregion

        //region Constructor
        public AddAndEditImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            itemRecyclerImagesProductImageButtonDelete = itemView.findViewById(R.id.item_recycler_images_product_image_button_delete);
            itemRecyclerImagesProductImageView = itemView.findViewById(R.id.item_recycler_images_product_image_view);
            itemRecyclerImagesProductImageButtonDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onAddAndEditImagesAdapterClickListeners.onItemRecyclerImagesProductImageButtonDelete(fileList.get(getAdapterPosition()), getAdapterPosition());
            refreshData(fileList);
        }

        //endregion
    }
    //endregion


}

