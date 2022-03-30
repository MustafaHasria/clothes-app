package com.example.clothes_app.view.productextensions;

import static com.example.clothes_app.app.AppConst.COLOR;
import static com.example.clothes_app.app.AppConst.GENDER_ID;
import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.MADE_OF;
import static com.example.clothes_app.app.AppConst.NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentProductExtensionsBinding;
import com.example.clothes_app.model.entity.Color;
import com.example.clothes_app.model.entity.Gender;
import com.example.clothes_app.model.entity.Size;
import com.example.clothes_app.model.entity.Tissue;
import com.example.clothes_app.view.productextensions.adapter.ColorAdapter;
import com.example.clothes_app.view.productextensions.adapter.GenderAdapter;
import com.example.clothes_app.view.productextensions.adapter.SizeAdapter;
import com.example.clothes_app.view.productextensions.adapter.TissueAdapter;
import com.example.clothes_app.view.productextensions.dialog.DialogAddAndEditColor;
import com.example.clothes_app.view.productextensions.dialog.DialogAddAndEditGender;
import com.example.clothes_app.view.productextensions.dialog.DialogAddAndEditSize;
import com.example.clothes_app.view.productextensions.dialog.DialogAddAndEditTissue;

import java.util.ArrayList;
import java.util.List;


public class ProductExtensionsFragment extends Fragment implements ColorAdapter.OnColorAdapterClickListeners,
        GenderAdapter.OnGenderAdapterClickListeners,
        SizeAdapter.OnSizeAdapterClickListeners,
        TissueAdapter.OnTissueAdapterClickListeners {

    //region Variables
    FragmentProductExtensionsBinding binding;

    List<Color> colorList;
    List<Gender> genderList;
    List<Size> sizeList;
    List<Tissue> tissueList;

    ColorAdapter colorAdapter;
    GenderAdapter genderAdapter;
    SizeAdapter sizeAdapter;
    TissueAdapter tissueAdapter;

    ProductExtensionsViewModel productExtensionsViewModel;

    Animation rotateOpen;
    Animation rotateClose;
    Animation fromBottom;
    Animation toBottom;

    boolean clicked = false;
    //endregion

    //region Life cycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //binding
        View view = inflater.inflate(R.layout.fragment_product_extensions, container, false);
        binding = FragmentProductExtensionsBinding.bind(view);

        //ViewModel
        productExtensionsViewModel = new ViewModelProvider(requireActivity()).get(ProductExtensionsViewModel.class);

        //animation
        rotateOpen = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(getContext(), R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(getContext(), R.anim.to_bottom_anim);

        //getAllColors
        productExtensionsViewModel.getAllColors().observe(requireActivity(), colors -> {
            if (colors.size() == 0)
                binding.fragmentProductExtensionsNoData.noDataLayoutLinearLayoutMainContainer.setVisibility(View.VISIBLE);
            else
                binding.fragmentProductExtensionsNoData.noDataLayoutLinearLayoutMainContainer.setVisibility(View.GONE);
            colorAdapter.submitList(colors);
        });

        //getAllGenders
        productExtensionsViewModel.getAllGenders().observe(requireActivity(), genders -> {
            genderAdapter.submitList(genders);
        });

        //getAllSizes
        productExtensionsViewModel.getAllSizes().observe(requireActivity(), sizes -> {
            sizeAdapter.submitList(sizes);
        });

        //getAllTissues

        productExtensionsViewModel.getAllTissues().observe(requireActivity(), tissues -> {
            tissueAdapter.submitList(tissues);
        });

        //setup recycler view
        setupColorRecyclerView();
        setupGenderRecyclerView();
        setupSizeRecyclerView();
        setupTissueRecyclerView();

        // buttons listeners
        binding.fragmentProductExtensionsFloatingActionButtonAdd.setOnClickListener(view1 -> {
            onAddButtonClicked();
        });
        binding.fragmentProductExtensionsFloatingActionButtonColor.setOnClickListener(view1 -> {
            DialogAddAndEditColor dialogAddAndEditColor = new DialogAddAndEditColor();
            dialogAddAndEditColor.setTargetFragment(this, 1);
            dialogAddAndEditColor.show(getFragmentManager(), null);
        });
        binding.fragmentProductExtensionsFloatingActionButtonGender.setOnClickListener(view1 -> {
            DialogAddAndEditGender dialogAddAndEditGender = new DialogAddAndEditGender();
            dialogAddAndEditGender.setTargetFragment(this, 1);
            dialogAddAndEditGender.show(getFragmentManager(), null);
        });
        binding.fragmentProductExtensionsFloatingActionButtonSize.setOnClickListener(view1 -> {
            DialogAddAndEditSize dialogAddAndEditSize = new DialogAddAndEditSize();
            dialogAddAndEditSize.setTargetFragment(this, 1);
            dialogAddAndEditSize.show(getFragmentManager(), null);
        });
        binding.fragmentProductExtensionsFloatingActionButtonTissue.setOnClickListener(view1 -> {
            DialogAddAndEditTissue dialogAddAndEditTissue = new DialogAddAndEditTissue();
            dialogAddAndEditTissue.setTargetFragment(this, 1);
            dialogAddAndEditTissue.show(getFragmentManager(), null);
        });

        return view;
    }
    //endregion

    //region Setups

    private void setupColorRecyclerView() {
        colorList = new ArrayList<>();
        colorAdapter = new ColorAdapter(colorList, this);
        binding.fragmentProductExtensionsRecyclerViewColors.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentProductExtensionsRecyclerViewColors.setHasFixedSize(true);
        binding.fragmentProductExtensionsRecyclerViewColors.setAdapter(colorAdapter);
    }

    private void setupGenderRecyclerView() {
        genderList = new ArrayList<>();
        genderAdapter = new GenderAdapter(genderList, this);
        binding.fragmentProductExtensionsRecyclerViewGenders.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentProductExtensionsRecyclerViewGenders.setHasFixedSize(true);
        binding.fragmentProductExtensionsRecyclerViewGenders.setAdapter(genderAdapter);
    }

    private void setupSizeRecyclerView() {
        sizeList = new ArrayList<>();
        sizeAdapter = new SizeAdapter(sizeList, this);
        binding.fragmentProductExtensionsRecyclerViewSizes.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentProductExtensionsRecyclerViewSizes.setHasFixedSize(true);
        binding.fragmentProductExtensionsRecyclerViewSizes.setAdapter(sizeAdapter);
    }

    private void setupTissueRecyclerView() {
        tissueList = new ArrayList<>();
        tissueAdapter = new TissueAdapter(tissueList, this);
        binding.fragmentProductExtensionsRecyclerViewTissues.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentProductExtensionsRecyclerViewTissues.setHasFixedSize(true);
        binding.fragmentProductExtensionsRecyclerViewTissues.setAdapter(tissueAdapter);
    }
    //endregion

    //region Adapter listeners
    //region Color
    @Override
    public void onItemRecyclerColorCardViewMainContainerClickListener(Color color, int position) {
        DialogAddAndEditColor dialogAddAndEditColor = new DialogAddAndEditColor();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, color.getId());
        bundle.putString(NAME, color.getName());
        bundle.putString(COLOR, color.getColor());
        dialogAddAndEditColor.setArguments(bundle);
        dialogAddAndEditColor.setTargetFragment(this, 1);
        dialogAddAndEditColor.show(getFragmentManager(), null);

    }

    @Override
    public void onItemRecyclerColorImageViewDelete(Color color, int position) {
        productExtensionsViewModel.deleteColor(color);
    }
    //endregion

    //region Gender
    @Override
    public void onItemRecyclerGenderCardViewMainContainerClickListener(Gender gender, int position) {

        DialogAddAndEditGender dialogAddAndEditGender = new DialogAddAndEditGender();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, gender.getId());
        bundle.putString(NAME, gender.getName());
        dialogAddAndEditGender.setArguments(bundle);
        dialogAddAndEditGender.setTargetFragment(this, 1);
        dialogAddAndEditGender.show(getFragmentManager(), null);
    }

    @Override
    public void onItemRecyclerGenderImageViewDelete(Gender gender, int position) {
        productExtensionsViewModel.deleteGender(gender);

    }
    //endregion

    //region Size
    @Override
    public void onItemRecyclerSizeCardViewMainContainerClickListener(Size size, int position) {
        DialogAddAndEditSize dialogAddAndEditSize = new DialogAddAndEditSize();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, size.getId());
        bundle.putString(NAME, size.getName());
        bundle.putInt(GENDER_ID, size.getIdGender());
        dialogAddAndEditSize.setArguments(bundle);
        dialogAddAndEditSize.setTargetFragment(this, 1);
        dialogAddAndEditSize.show(getFragmentManager(), null);
    }

    @Override
    public void onItemRecyclerSizeImageViewDelete(Size size, int position) {
        productExtensionsViewModel.deleteSize(size);

    }

    //endregion
    //region Tissue

    @Override
    public void onItemRecyclerTissueCardViewMainContainerClickListener(Tissue tissue, int position) {
        DialogAddAndEditTissue dialogAddAndEditTissue = new DialogAddAndEditTissue();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, tissue.getId());
        bundle.putString(NAME, tissue.getName());
        bundle.putString(MADE_OF, tissue.getMadeOf());
        dialogAddAndEditTissue.setArguments(bundle);
        dialogAddAndEditTissue.setTargetFragment(this, 1);
        dialogAddAndEditTissue.show(getFragmentManager(), null);
    }

    @Override
    public void onItemRecyclerTissueImageViewDelete(Tissue tissue, int position) {
        productExtensionsViewModel.deleteTissue(tissue);
    }


    //endregion


    //endregion

    //region Methods
    private void setVisibility(boolean clicked) {
        if (!clicked) {
            binding.fragmentProductExtensionsFloatingActionButtonSize.setVisibility(View.VISIBLE);
            binding.fragmentProductExtensionsFloatingActionButtonColor.setVisibility(View.VISIBLE);
            binding.fragmentProductExtensionsFloatingActionButtonGender.setVisibility(View.VISIBLE);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.setVisibility(View.VISIBLE);
            binding.fragmentProductExtensionsFloatingActionButtonSize.setClickable(true);
            binding.fragmentProductExtensionsFloatingActionButtonColor.setClickable(true);
            binding.fragmentProductExtensionsFloatingActionButtonGender.setClickable(true);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.setClickable(true);
        } else {
            binding.fragmentProductExtensionsFloatingActionButtonSize.setVisibility(View.GONE);
            binding.fragmentProductExtensionsFloatingActionButtonColor.setVisibility(View.GONE);
            binding.fragmentProductExtensionsFloatingActionButtonGender.setVisibility(View.GONE);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.setVisibility(View.GONE);
            binding.fragmentProductExtensionsFloatingActionButtonSize.setClickable(false);
            binding.fragmentProductExtensionsFloatingActionButtonColor.setClickable(false);
            binding.fragmentProductExtensionsFloatingActionButtonGender.setClickable(false);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.setClickable(false);
        }
    }

    private void setAnimation(boolean clicked) {
        if (!clicked) {
            binding.fragmentProductExtensionsFloatingActionButtonSize.startAnimation(fromBottom);
            binding.fragmentProductExtensionsFloatingActionButtonColor.startAnimation(fromBottom);
            binding.fragmentProductExtensionsFloatingActionButtonGender.startAnimation(fromBottom);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.startAnimation(fromBottom);
            binding.fragmentProductExtensionsFloatingActionButtonAdd.startAnimation(rotateOpen);
        } else {
            binding.fragmentProductExtensionsFloatingActionButtonSize.startAnimation(toBottom);
            binding.fragmentProductExtensionsFloatingActionButtonColor.startAnimation(toBottom);
            binding.fragmentProductExtensionsFloatingActionButtonGender.startAnimation(toBottom);
            binding.fragmentProductExtensionsFloatingActionButtonTissue.startAnimation(toBottom);
            binding.fragmentProductExtensionsFloatingActionButtonAdd.startAnimation(rotateClose);
        }
    }

    private void onAddButtonClicked() {
        setVisibility(clicked);
        setAnimation(clicked);
        clicked = !clicked;
    }

    //endregion
}