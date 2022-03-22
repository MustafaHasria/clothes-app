package com.example.clothes_app.view.productextensions.dialog;

import static com.example.clothes_app.app.AppConst.COLOR;
import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.NAME;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.DialogAddAndEditColorBinding;
import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.view.productextensions.ProductExtensionsViewModel;

public class DialogAddAndEditColor extends DialogFragment {

    //region Variables
    DialogAddAndEditColorBinding binding;
    ProductExtensionsViewModel productExtensionsViewModel;
    int color;
    Bundle bundle;
    //endregion

    //region Life cycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_and_edit_color, container, false);
        binding = DialogAddAndEditColorBinding.bind(view);
        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);
        bundle = getArguments();
        if (bundle != null) {
            binding.dialogAddAndEditColorButtonCreate.setText(R.string.save);
            binding.dialogAddAndEditColorEditTextName.setText(bundle.getString(NAME));
            binding.dialogAddAndEditColorColorPicker.setInitialColor(Integer.parseInt(bundle.getString(COLOR)));
            binding.dialogAddAndEditColorImageButtonColor.setBackgroundTintList(ColorStateList.valueOf(Integer.parseInt(bundle.getString(COLOR))));
            binding.dialogAddAndEditColorTextViewTitle.setText(R.string.edit_color);
        }
        binding.dialogAddAndEditColorColorPicker.subscribe((color, fromUser, shouldPropagate) -> {
            this.color = color;
            binding.dialogAddAndEditColorImageButtonColor.setBackgroundTintList(ColorStateList.valueOf(color));
        });

        binding.dialogAddAndEditColorButtonCreate.setOnClickListener(view1 -> {
            Color myColor = new Color(binding.dialogAddAndEditColorEditTextName.getText().toString(), String.valueOf(color));
            if (validation())
                if (binding.dialogAddAndEditColorButtonCreate.getText().toString().equals(getContext().getString(R.string.save))) {
                    myColor.setId(bundle.getInt(ID));
                    productExtensionsViewModel.updateColor(myColor);
                } else
                    productExtensionsViewModel.insertColor(myColor);

        });
        return view;
    }

    //endregion

    //region Methods
    private boolean validation() {
        return !binding.dialogAddAndEditColorEditTextName.getText().toString().isEmpty();
    }
    //endregion
}

