package com.example.clothes_app.view.dashboard.products.addproduct.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.DialogSelectColorBinding;
import com.example.clothes_app.model.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class DialogSelectColor extends DialogFragment implements ShowColorAdapter.OnShowColorAdapterClickListeners {

    //region Variables
    DialogSelectColorBinding binding;
    Bundle bundle;
    List<Color> colorList;
    ShowColorAdapter showColorAdapter;
    //endregion

    //region Life cycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_select_color, container, false);
        binding = DialogSelectColorBinding.bind(view);

        return view;
    }

    //endregion

    //region Initializing
    private void setupRecyclerView() {
        colorList = new ArrayList<>();
        showColorAdapter = new ShowColorAdapter(colorList, this);
        binding.dialogSelectColorRecyclerViewColor.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.dialogSelectColorRecyclerViewColor.setHasFixedSize(true);
        binding.dialogSelectColorRecyclerViewColor.setAdapter(showColorAdapter);
    }

    //endregion

    //region Adapter click listeners
    @Override
    public void onItemRecycleShowColorCheckBoxCheckedChangeListener(Color color, int position) {

    }
    //endregion

}

