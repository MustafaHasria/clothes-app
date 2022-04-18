package com.example.clothes_app.view.dashboard.products.addproduct;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentAddAndEditProductBinding;

public class AddAndEditProductFragment extends Fragment {

    //region Variables
    FragmentAddAndEditProductBinding binding;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_and_edit_product, container, false);
        binding = FragmentAddAndEditProductBinding.bind(view);

        binding.fragmentAddAndEditProductButtonSelectColor.setOnClickListener(view1 -> {

        });
        return view;
    }
    //endregion

}