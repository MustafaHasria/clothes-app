package com.example.clothes_app.view.productextensions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentProductExtenstionsBinding;
import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.view.productextensions.adapter.ColorAdapter;

import java.util.ArrayList;
import java.util.List;


public class ProductExtensionsFragment extends Fragment implements ColorAdapter.OnColorAdapterClickListeners {

    //region Variables
    FragmentProductExtenstionsBinding binding;
    List<Color> colorList;
    ColorAdapter colorAdapter;
    ProductExtensionsViewModel productExtensionsViewModel;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_extenstions, container, false);
        binding = FragmentProductExtenstionsBinding.bind(view);
        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);

        productExtensionsViewModel.getAllColors().observe(requireActivity(), colors -> colorAdapter.submitList(colors));

        setupColorRecyclerView();

        return view;
    }
    //endregion

    //region Setups

    private void setupColorRecyclerView() {
        colorList = new ArrayList<>();
        colorAdapter = new ColorAdapter(colorList, this);
        binding.fragmentRecyclerViewColors.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentRecyclerViewColors.setHasFixedSize(true);
        binding.fragmentRecyclerViewColors.setAdapter(colorAdapter);
    }

    //endregion

    //region Adapter listeners

    @Override
    public void onItemRecyclerColorCardViewMainContainerClickListener(Color color, int position) {

    }

    @Override
    public void onItemRecyclerColorImageViewDelete(Color color, int position) {

    }
    //endregion
}