package com.example.clothes_app.view.dashboard.products.addproduct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentAddAndEditProductBinding;
import com.example.clothes_app.model.entity.File;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.model.entity.Tissue;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddAndEditProductFragment extends Fragment implements AddAndEditImagesAdapter.OnAddAndEditImagesAdapterClickListeners {

    //region Variables
    FragmentAddAndEditProductBinding binding;
    AddAndEditProductViewModel addAndEditProductViewModel;
    List<File> fileList;
    AddAndEditImagesAdapter addAndEditImagesAdapter;
    int idSize;
    List<Size> sizeList;
    int idTissue;
    List<Tissue> tissueList;

    ArrayAdapter sizeAdapter, seasonAdapter, tissueAdapter;
    String seasonName;

    String[] collectionSeason = {"Spring", "Summer",
            "Autumn", "Winter"};
    Bundle bundle;

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if (result.getContents() == null) {
                    Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(requireActivity(), "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                }
            });
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

        //spinners
        addAndEditProductViewModel = new ViewModelProvider(requireActivity()).get(AddAndEditProductViewModel.class);
        addAndEditProductViewModel.getAllSizes().observe(requireActivity(), sizes -> {
            idSize = sizes.get(0).getId();
            sizeList = sizes;

            if (sizes != null && getContext() != null) {
                sizeAdapter =
                        new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, sizes);
                sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.fragmentAddAndEditProductSpinnerSize.setAdapter(sizeAdapter);
            }

        });

        addAndEditProductViewModel.getAllTissue().observe(requireActivity(), tissues -> {
            idTissue = tissues.get(0).getId();
            tissueList = tissues;

            if (tissues != null && getContext() != null) {
                tissueAdapter =
                        new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, tissues);
                tissueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.fragmentAddAndEditProductSpinnerTypeOfTissue.setAdapter(tissueAdapter);
            }

        });

        seasonAdapter =
                new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, collectionSeason);
        seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.fragmentAddAndEditProductSpinnerCollectionSeason.setAdapter(seasonAdapter);

        binding.fragmentAddAndEditProductEditTextInputLayoutQrCode.setEndIconOnClickListener(view1 -> {
            barcodeLauncher.launch(new ScanOptions());
        });

        bundle = getArguments();
        binding.fragmentAddAndEditProductButtonSelectColor.setOnClickListener(view1 -> {

        });

        binding.fragmentAddAndEditProductButtonAddImage.setOnClickListener(view1 -> {
            checkPermissions();
        });

        binding.fragmentAddAndEditProductSpinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idSize = sizeList.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.fragmentAddAndEditProductSpinnerCollectionSeason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                seasonName = binding.fragmentAddAndEditProductSpinnerCollectionSeason.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
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
//        startActivityForResult(inte);
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
        if (fileList.size() > 0) {
            fileList.remove(position);

        }

    }
    //endregion

}