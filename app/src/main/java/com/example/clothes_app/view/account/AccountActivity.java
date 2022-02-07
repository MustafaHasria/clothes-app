package com.example.clothes_app.view.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.databinding.ActivityAccountBinding;
import com.example.clothes_app.model.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    //region Variables
    AccountAdapter accountAdapter;
    List<Account> accountList;
    AccountViewModel accountViewModel;
    ActivityAccountBinding binding;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecyclerView();
        accountViewModel = new ViewModelProvider(AccountActivity.this).get(AccountViewModel.class);
        accountViewModel.getAllAccounts().observe(AccountActivity.this, new Observer<List<Account>>() {
            @Override
            public void onChanged(List<Account> accounts) {
                accountAdapter.submitList(accounts);
            }
        });

    }

    //region Methods

    //endregion

    //region Initializing
    private void setupRecyclerView() {
        accountList = new ArrayList<>();
        accountAdapter = new AccountAdapter(accountList);
        binding.activityAccountRecyclerViewAccounts.setLayoutManager(new LinearLayoutManager(AccountActivity.this));
        binding.activityAccountRecyclerViewAccounts.setHasFixedSize(true);
        binding.activityAccountRecyclerViewAccounts.setAdapter(accountAdapter);
    }
    //endregion
}