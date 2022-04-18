package com.example.clothes_app.view.dashboard.products;

import static com.example.clothes_app.app.AppConst.FRAGMENT_ACCOUNT;
import static com.example.clothes_app.app.AppConst.FRAGMENT_ADD_AND_EDIT_ACCOUNT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentProductBinding;
import com.example.clothes_app.view.dashboard.products.addproduct.AddAndEditProductFragment;

public class ProductFragment extends Fragment {

    //region Variables
    FragmentProductBinding binding;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        binding = FragmentProductBinding.bind(view);

        binding.fragmentProductFloatingActionButtonAdd.setOnClickListener(view1 -> {
            moveToAddAndEditFragment(new AddAndEditProductFragment());
        });
        return view;
    }
    //endregion

    //region Methods
    private void moveToAddAndEditFragment(AddAndEditProductFragment addAndEditProductFragment) {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.activity_main_frame_layout_main_container, addAndEditProductFragment, FRAGMENT_ADD_AND_EDIT_ACCOUNT)
                .addToBackStack(FRAGMENT_ACCOUNT)
                .commit();
    }
    //endregion
}