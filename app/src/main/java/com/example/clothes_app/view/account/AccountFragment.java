package com.example.clothes_app.view.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentAccountBinding;
import com.example.clothes_app.model.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {
    //region Variables
    AccountAdapter accountAdapter;
    List<Account> accountList;
    AccountViewModel accountViewModel;
    FragmentAccountBinding binding;
    //endregion


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        binding = FragmentAccountBinding.bind(view);
        setupRecyclerView();

        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModel.class);
        accountViewModel.getAllAccounts().observe(requireActivity(), accounts -> accountAdapter.submitList(accounts));
        return view;
    }

    //region Initializing
    private void setupRecyclerView() {
        accountList = new ArrayList<>();
        accountAdapter = new AccountAdapter(accountList);
        binding.fragmentAddAccountRecyclerViewAccounts.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentAddAccountRecyclerViewAccounts.setHasFixedSize(true);
        binding.fragmentAddAccountRecyclerViewAccounts.setAdapter(accountAdapter);
    }
    //endregion
}