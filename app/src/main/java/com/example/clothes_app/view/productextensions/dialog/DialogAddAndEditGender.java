package com.example.clothes_app.view.productextensions.dialog;

import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.DialogAddAndEditGenderBinding;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.view.productextensions.ProductExtensionsViewModel;

public class DialogAddAndEditGender extends DialogFragment {

    //region Variables
    DialogAddAndEditGenderBinding binding;
    ProductExtensionsViewModel productExtensionsViewModel;
    Bundle bundle;
    //endregion

    //region Life cycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_and_edit_gender, container, false);
        binding = DialogAddAndEditGenderBinding.bind(view);
        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);
        bundle = getArguments();
        if (bundle != null) {
            binding.dialogAddAndEditGenderButtonCreate.setText(R.string.save);
            binding.dialogAddAndEditGenderEditTextName.setText(bundle.getString(NAME));
            binding.dialogAddAndEditGenderTextViewTitle.setText(R.string.edit_gender);
        }

        binding.dialogAddAndEditGenderButtonCreate.setOnClickListener(view1 -> {
            Gender myGender = new Gender(binding.dialogAddAndEditGenderEditTextName.getText().toString());
            if (validation())
                if (binding.dialogAddAndEditGenderButtonCreate.getText().toString().equals(getContext().getString(R.string.save))) {
                    myGender.setId(bundle.getInt(ID));
                    productExtensionsViewModel.updateGender(myGender);
                } else
                    productExtensionsViewModel.insertGender(myGender);

        });
        return view;
    }

    //endregion

    //region Methods
    private boolean validation() {
        return !binding.dialogAddAndEditGenderEditTextName.getText().toString().isEmpty();
    }
    //endregion
}

