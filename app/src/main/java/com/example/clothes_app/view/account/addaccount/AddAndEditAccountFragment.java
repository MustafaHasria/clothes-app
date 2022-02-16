package com.example.clothes_app.view.account.addaccount;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.R;
import com.example.clothes_app.app.AppConst;
import com.example.clothes_app.databinding.FragmentAddAndEditAccountBinding;
import com.example.clothes_app.model.entity.Account;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class AddAndEditAccountFragment extends Fragment {

    //region Variables
    FragmentAddAndEditAccountBinding binding;
    String username, password, confirmPassword, email, address, genderString, roleString;
    int role;
    boolean gender;
    AddAndEditAccountViewModel addAndEditAccountViewModel;
    Bitmap bitmap;
    Bundle bundle;
    //endregion

    //region Life cycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_and_edit_account, container, false);
        binding = FragmentAddAndEditAccountBinding.bind(view);
        bitmap = null;
        bundle = getArguments();
        checkingBundle();
        binding.myAccountImageButtonAddPhoto.setOnClickListener(view1 -> {
            checkPermissions();
        });
        addAndEditAccountViewModel = new ViewModelProvider(requireActivity()).get(AddAndEditAccountViewModel.class);

        binding.fragmentAddAndEditAccountImageViewBack.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
        binding.fragmentAddAndEditAccountButtonCreate.setOnClickListener(view1 -> {
            password = binding.fragmentAddAndEditAccountEditTextPassword.getText().toString();
            confirmPassword = binding.fragmentAddAndEditAccountEditTextConfirmPassword.getText().toString();
            //TODO don't forget to validate all inputs
            Account account = null;
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getContext(), "The password and confirm password not the same", Toast.LENGTH_SHORT).show();
            } else {
                email = binding.fragmentAddAndEditAccountEditTextEmail.getText().toString();
                address = binding.fragmentAddAndEditAccountEditTextAddress.getText().toString();
                username = binding.fragmentAddAndEditAccountEditTextUsername.getText().toString();
                int selectedIdGender = binding.fragmentAddAndEditAccountRadioGroupGender.getCheckedRadioButtonId();
                int selectedIdRole = binding.fragmentAddAndEditAccountRadioGroupGender.getCheckedRadioButtonId();
                genderString = ((RadioButton) container.findViewById(selectedIdGender)).getText().toString();
                gender = genderString.equals("Male");
                roleString = ((RadioButton) container.findViewById(selectedIdRole)).getText().toString();
                if (roleString.equals("Representative"))
                    role = 3;
                else role = 2;
                account = new Account(username, password, bitmapToByteArray(bitmap), email, "09",
                        address, gender, role);
            }
            if (bundle == null && account != null) {
                addAndEditAccountViewModel.insert(account);
                binding.fragmentAddAndEditAccountEditTextEmail.setText("");

            } else if (account != null) {
                account.setId(bundle.getInt(AppConst.ID));
                addAndEditAccountViewModel.update(account);
                binding.fragmentAddAndEditAccountEditTextEmail.setText("");
            }
        });
        return view;
    }

    //endregion

    //region Request permission


    //endregion

    //region On activity result
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        binding.fragmentAddAndEditAccountCircularImage.setImageBitmap(bitmap);
    }
    //endregion

    //region Methods
    private void checkPermissions() {
        chooseImage();
    }

    private void chooseImage() {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "choose picture"), 102);
    }

    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void checkingBundle() {
        if (bundle != null) {
            binding.fragmentAddAndEditAccountEditTextEmail.setText(bundle.getString(AppConst.EMAIL));
            binding.fragmentAddAndEditAccountEditTextUsername.setText(bundle.getString(AppConst.USERNAME));
            binding.fragmentAddAndEditAccountEditTextAddress.setText(bundle.getString(AppConst.ADDRESS));
            binding.fragmentAddAndEditAccountEditTextPassword.setText(bundle.getString(AppConst.PASSWORD));
            byte[] picture = bundle.getByteArray(AppConst.PICTURE);
            bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);
            binding.fragmentAddAndEditAccountCircularImage.setImageBitmap(bitmap);
            binding.fragmentAddAndEditAccountTextViewAppbarTitle.setText(requireActivity().getResources().getString(R.string.edit_account));
            binding.fragmentAddAndEditAccountTextViewCreateDescriptionTitle.setVisibility(View.GONE);
            binding.fragmentAddAndEditAccountTextViewCreateTitle.setVisibility(View.GONE);
            binding.fragmentAddAndEditAccountButtonCreate.setText(requireActivity().getResources().getString(R.string.save));
        }
    }
    //endregion
}