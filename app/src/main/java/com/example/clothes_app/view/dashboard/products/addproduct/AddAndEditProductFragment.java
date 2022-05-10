package com.example.clothes_app.view.dashboard.products.addproduct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentAddAndEditProductBinding;
import com.example.clothes_app.model.entity.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAndEditProductFragment extends Fragment implements AddAndEditImagesAdapter.OnAddAndEditImagesAdapterClickListeners{

    //region Variables
    FragmentAddAndEditProductBinding binding;
    List<File> fileList;
    AddAndEditImagesAdapter addAndEditImagesAdapter;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_and_edit_product, container, false);
        binding = FragmentAddAndEditProductBinding.bind(view);
        fileList = new ArrayList<>();
        setupImagesRecyclerView();
        binding.fragmentAddAndEditProductButtonSelectColor.setOnClickListener(view1 -> {

        });

        binding.fragmentAddAndEditProductButtonAddImage.setOnClickListener(view1 -> {
            checkPermissions();
        });
        return view;
    }
    //endregion

    //region Setups
    void setupImagesRecyclerView() {
        addAndEditImagesAdapter = new AddAndEditImagesAdapter(fileList, this);
        binding.fragmentAddAndEditProductRecyclerViewImages.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.fragmentAddAndEditProductRecyclerViewImages.setHasFixedSize(true);
        binding.fragmentAddAndEditProductRecyclerViewImages.setAdapter(addAndEditImagesAdapter);
    }
    //endregion

    //region On activity result
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileList.add(new File(bitmapToByteArray(bitmap)));
        addAndEditImagesAdapter.refreshData(fileList);
    }
    //endregion

    //region Methods

    private void checkPermissions() {
        chooseImage();
    }

    private void chooseImage() {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "choose picture"), 102);
    }

    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    //endregion

    //region Adapter click listeners

    @Override
    public void onItemRecyclerImagesProductImageButtonDelete(File file, int position) {

    }
    //endregion

}