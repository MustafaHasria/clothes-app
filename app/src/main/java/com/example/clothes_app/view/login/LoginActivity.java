package com.example.clothes_app.view.login;

import static com.example.clothes_app.app.AppConst.USER;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.clothes_app.databinding.ActivityLoginBinding;
import com.example.clothes_app.view.main.MainActivity;

import io.paperdb.Paper;

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
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.registrationButtonLoginRegister.setOnClickListener(View -> {
                    username = binding.activityLoginEditTextUsername.getText().toString();
                    password = binding.activityLoginEditTextPassword.getText().toString();

                    if (validateInputs()) {
                        loginViewModel.getUserAccount(username, password).observe(this, accountList -> {
                            if (accountList.size() != 0) {
                                Paper.book().write(USER, accountList.get(0));
                                startActivity(new Intent(this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "This user does not exist.", Toast.LENGTH_SHORT).show();
                            }
                        });

//                        AsyncTask.execute(() -> {
//                            List<Account> listUserAccount = loginViewModel.getUserAccount(username, password);
//                            if (listUserAccount.size() != 0) {
////                                Intent intent = new Intent(this, MainActivity.class);
//                                startActivity(new Intent(this, MainActivity.class));
//                                finish();
//                            } else {
//                                new Handler(Looper.getMainLooper()).post(() -> {
//                                    Toast.makeText(getApplicationContext(), "This user does not exist.", Toast.LENGTH_SHORT).show();
//                                });
//
//                            }
//                        });
                    }


                }

        );

    }

    //endregion

    //region Methods
    private boolean validateInputs() {
        if (password.isEmpty()) {
            Toast.makeText(this, "Please insert your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username.isEmpty()) {
            Toast.makeText(this, "please insert your username", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    //endregion

}