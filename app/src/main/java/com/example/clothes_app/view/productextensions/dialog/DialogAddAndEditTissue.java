package com.example.clothes_app.view.productextensions.dialog;

import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.MADE_OF;
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
import com.example.clothes_app.databinding.DialogAddAndEditTissueBinding;
import com.example.clothes_app.model.entity.Tissue;
import com.example.clothes_app.view.productextensions.ProductExtensionsViewModel;

public class DialogAddAndEditTissue extends DialogFragment {
    //region Variables
    DialogAddAndEditTissueBinding binding;
    ProductExtensionsViewModel productExtensionsViewModel;
    Bundle bundle;
    //endregion
    //region LifeCycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_and_edit_tissue, container, false);
        binding = DialogAddAndEditTissueBinding.bind(view);
        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);

        bundle = getArguments();
        if (bundle != null) {

            binding.dialogAddAndEditTissueButtonCreate.setText(R.string.save);
            binding.dialogAddAndEditTissueEditTextName.setText(bundle.getString(NAME));
            binding.dialogAddAndEditTissueEditTextMadeOf.setText(bundle.getString(MADE_OF));
        }

        binding.dialogAddAndEditTissueButtonCreate.setOnClickListener(view1 -> {

            Tissue tissue = new Tissue(binding.dialogAddAndEditTissueEditTextName.getText().toString(),
                    binding.dialogAddAndEditTissueEditTextMadeOf.getText().toString());
            if (validation())
                if (binding.dialogAddAndEditTissueButtonCreate.getText().toString().equals(getContext().getString(R.string.save))) {
                    tissue.setId(bundle.getInt(ID));
                    productExtensionsViewModel.updateTissue(tissue);
                } else
                    productExtensionsViewModel.insertTissue(tissue);

        });

        return view;
    }

    //endregion

    //region Methods
    private boolean validation() {
        return (!binding.dialogAddAndEditTissueEditTextName.getText().toString().isEmpty() &&
                !binding.dialogAddAndEditTissueEditTextMadeOf.getText().toString().isEmpty());

    }
    //endregion
}
