package com.example.clothes_app.view.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.ActivityLoginBinding;
import com.example.clothes_app.model.entity.Account;
import com.example.clothes_app.view.dashboard.DashboardFragment;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    //region Variables

    LoginViewModel loginViewModel;
    ActivityLoginBinding binding;

    String username;
    String password;

    //endregion
    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //ViewModel
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        //binding
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_login, container, false);
        binding = ActivityLoginBinding.bind(view);

        binding.registrationButtonLoginRegister.setOnClickListener(View -> {

                    username = binding.activityLoginTextInputEditTextUsername.getText().toString();
                    password = binding.activityLoginTextInputLayoutPassword.getText().toString();


                    List<Account> listuserAccount = null;
                    if (validateInputs()) {
                        listuserAccount = loginViewModel.getUserAccount(username, password);
                        if (listuserAccount.size() != 0) {
                            DashboardFragment dashboardFragment = new DashboardFragment();

                            FragmentTransaction fragmentTransaction =
                                    this.getSupportFragmentManager().beginTransaction();

                            //TODO Complete to go to the DashboardFragment
                        }
                    }


                }

        );


        return view;

    }
    //endregion

    //region Methods
    private boolean validateInputs() {
        if (password.trim().isEmpty()) {
            Toast.makeText(this, "Please insert your password", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (username.trim().isEmpty()) {
            Toast.makeText(this, "please insert your username", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    //endregion

}