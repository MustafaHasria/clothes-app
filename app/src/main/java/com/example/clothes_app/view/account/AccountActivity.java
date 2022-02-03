package com.example.clothes_app.view.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;

public class AccountActivity extends AppCompatActivity {

    //region Components
    RecyclerView activityAccountRecyclerViewAccounts;
    //endregion

    //region Variables

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        activityAccountRecyclerViewAccounts = findViewById(R.id.activity_account_recycler_view_accounts);

    }
}