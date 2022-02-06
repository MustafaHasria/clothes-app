package com.example.clothes_app.view.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    //region Components
    RecyclerView activityAccountRecyclerViewAccounts;
    //endregion

    //region Variables
    AccountAdapter accountAdapter;
    List<Account> accountList;
    AccountViewModel accountViewModel;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setFindViewByID();
        setupRecyclerView();
        accountViewModel = new ViewModelProvider(AccountActivity.this).get(AccountViewModel.class);
        accountViewModel.getAllAccounts().observe(AccountActivity.this, new Observer<List<Account>>() {
            @Override
            public void onChanged(List<Account> accounts) {
                accountAdapter.updateData(accounts);
            }
        });

    }

    //region Methods
    private void setFindViewByID() {
        activityAccountRecyclerViewAccounts = findViewById(R.id.activity_account_recycler_view_accounts);
    }
    //endregion

    //region Initializing
    private void setupRecyclerView() {
        accountList = new ArrayList<>();
        accountAdapter = new AccountAdapter(accountList);
        activityAccountRecyclerViewAccounts.setLayoutManager(new LinearLayoutManager(AccountActivity.this));
        activityAccountRecyclerViewAccounts.setHasFixedSize(true);
        activityAccountRecyclerViewAccounts.setAdapter(accountAdapter);
    }
    //endregion
}