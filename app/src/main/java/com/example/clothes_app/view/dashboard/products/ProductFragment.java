package com.example.clothes_app.view.dashboard.products;

import static com.example.clothes_app.app.AppConst.FRAGMENT_ADD_AND_EDIT_PRODUCT;
import static com.example.clothes_app.app.AppConst.FRAGMENT_PRODUCT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentProductBinding;
import com.example.clothes_app.model.entity.Product;
import com.example.clothes_app.view.dashboard.products.addproduct.AddAndEditProductFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment implements ProductAdapter.OnProductAdapterClickListeners {


    //region Variables
    ProductAdapter productAdapter;
    FragmentProductBinding binding;
    List<Product> productList;
    ProductViewModel productViewModel;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //layout or UI
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        //binding
        binding = FragmentProductBinding.bind(view);

        //adapter(arraylist to adapter)
        setupRecyclerView();

        //view Model (to bring data from database all products and store it in products)

        ProductViewModel productViewModel = new ViewModelProvider(requireActivity()).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(requireActivity(), products -> productAdapter.submitList(products));

        binding.fragmentProductFloatingActionButtonAdd.setOnClickListener(view1 -> {
            moveToAddAndEditFragment(new AddAndEditProductFragment());
        });
        return view;
    }
    //endregion

    //region Initializing
    private void setupRecyclerView() {
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList, this);
        binding.fragmentProductRecyclerViewProducts.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentProductRecyclerViewProducts.setHasFixedSize(true);
        binding.fragmentProductRecyclerViewProducts.setAdapter(productAdapter);
    }

    //endregion
    //region Methods
    private void moveToAddAndEditFragment(AddAndEditProductFragment addAndEditProductFragment) {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.activity_main_frame_layout_main_container, addAndEditProductFragment, FRAGMENT_ADD_AND_EDIT_PRODUCT)
                .addToBackStack(FRAGMENT_PRODUCT)
                .commit();
    }
    //endregion
}