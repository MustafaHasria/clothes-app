package com.example.clothes_app.view.account.addaccount;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.example.clothes_app.databinding.FragmentAddAccountBinding;
import com.example.clothes_app.model.entity.Account;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class AddAccountFragment extends Fragment {

    //region Variables
    FragmentAddAccountBinding binding;
    String username, password, confirmPassword, email, address, genderString, roleString;
    int role;
    boolean gender;
    AddAccountViewModel addAccountViewModel;
    Bitmap bitmap;
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
        View view = inflater.inflate(R.layout.fragment_add_account, container, false);
        binding = FragmentAddAccountBinding.bind(view);
        bitmap = null;
        binding.myAccountImageButtonAddPhoto.setOnClickListener(view1 -> {
            checkPermissions();
        });
        addAccountViewModel = new ViewModelProvider(requireActivity()).get(AddAccountViewModel.class);

        binding.fragmentAddAccountButtonCreate.setOnClickListener(view1 -> {
            password = binding.fragmentAddAccountEditTextPassword.getText().toString();
            confirmPassword = binding.fragmentAddAccountEditTextConfirmPassword.getText().toString();
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getContext(), "The password and confirm password not the same", Toast.LENGTH_SHORT).show();
            } else {
                email = binding.fragmentAddAccountEditTextEmail.getText().toString();
                address = binding.fragmentAddAccountEditTextAddress.getText().toString();
                username = binding.fragmentAddAccountEditTextUsername.getText().toString();
                int selectedIdGender = binding.fragmentAddAccountRadioGroupGender.getCheckedRadioButtonId();
                int selectedIdRole = binding.fragmentAddAccountRadioGroupGender.getCheckedRadioButtonId();
                genderString = ((RadioButton) container.findViewById(selectedIdGender)).getText().toString();
                gender = genderString.equals("Male");
                roleString = ((RadioButton) container.findViewById(selectedIdRole)).getText().toString();
                if (roleString.equals("Representative"))
                    role = 3;
                else role = 2;
                addAccountViewModel.insert(new Account(username, password, bitmapToByteArray(bitmap), email, "09",
                        address, gender, role));
                binding.fragmentAddAccountEditTextEmail.setText("");

            }
        });
        return view;
    }

    //endregion

    //region Request permission


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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        binding.fragmentAddAccountCircularImage.setImageBitmap(bitmap);
    }

    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    //endregion
}