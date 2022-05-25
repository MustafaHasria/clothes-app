package com.example.clothes_app.view.dashboard.productextensions.dialog;

import static com.example.clothes_app.app.AppConst.GENDER_ID;
import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.DialogAddAndEditSizeBinding;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.view.dashboard.productextensions.ProductExtensionsViewModel;

import java.util.List;

public class DialogAddAndEditSize extends DialogFragment {

    //region Variables
    DialogAddAndEditSizeBinding binding;
    ProductExtensionsViewModel productExtensionsViewModel;
    Bundle bundle;
    int idGender;
    ArrayAdapter adapter;
    List<Gender> genderList;
    //endregion

    //region Life cycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_and_edit_size, container, false);
        binding = DialogAddAndEditSizeBinding.bind(view);

        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);
        productExtensionsViewModel.getAllGenders().observe(requireActivity(), genders -> {
            idGender = genders.get(0).getId();

            genderList = genders;
            if (genders != null && getContext()!= null) {
                adapter =
                        new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, genders);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.dialogAddAndEditSizeSpinnerGender.setAdapter(adapter);
            }
        });
        bundle = getArguments();
        if (bundle != null) {
            binding.dialogAddAndEditSizeButtonCreate.setText(R.string.save);
            binding.dialogAddAndEditSizeEditTextName.setText(bundle.getString(NAME));
            binding.dialogAddAndEditSizeTextViewTitle.setText(R.string.edit_size);
            idGender = bundle.getInt(GENDER_ID);
        }

        binding.dialogAddAndEditSizeButtonCreate.setOnClickListener(view1 -> {
            Size mySize = new Size(binding.dialogAddAndEditSizeEditTextName.getText().toString(), idGender);
            if (validation())
                if (binding.dialogAddAndEditSizeButtonCreate.getText().toString().equals(getContext().getString(R.string.save))) {
                    mySize.setId(bundle.getInt(ID));
                    productExtensionsViewModel.updateSize(mySize);
                } else
                    productExtensionsViewModel.insertSize(mySize);

        });
        binding.dialogAddAndEditSizeSpinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idGender = genderList.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    //endregion

    //region Methods
    private boolean validation() {
        return !binding.dialogAddAndEditSizeEditTextName.getText().toString().isEmpty();
    }
    //endregion
}

