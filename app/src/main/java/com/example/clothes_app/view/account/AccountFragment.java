package com.example.clothes_app.view.account;

import static com.example.clothes_app.app.AppConst.FRAGMENT_ACCOUNT;
import static com.example.clothes_app.app.AppConst.FRAGMENT_ADD_ACCOUNT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentAccountBinding;
import com.example.clothes_app.model.entity.Account;
import com.example.clothes_app.view.account.addaccount.AddAccountFragment;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment implements AccountAdapter.OnAccountAdapterClickListeners{

    //region Variables
    AccountAdapter accountAdapter;
    List<Account> accountList;
    AccountViewModel accountViewModel;
    FragmentAccountBinding binding;
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        binding = FragmentAccountBinding.bind(view);
        setupRecyclerView();
        binding.fragmentAccountFloatingActionButtonAdd.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out,android.R.animator.fade_in, android.R.animator.fade_out)
                    .add(R.id.activity_main_frame_layout_main_container, new AddAccountFragment(), FRAGMENT_ADD_ACCOUNT)
                    .addToBackStack(FRAGMENT_ACCOUNT)
                    .commit();
        });

        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModel.class);
        accountViewModel.getAllAccounts().observe(requireActivity(), accounts -> accountAdapter.submitList(accounts));
        return view;
    }

    //endregion

    //region Initializing
    private void setupRecyclerView() {
        accountList = new ArrayList<>();
        accountAdapter = new AccountAdapter(accountList, this);
        binding.fragmentAddAccountRecyclerViewAccounts.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.fragmentAddAccountRecyclerViewAccounts.setHasFixedSize(true);
        binding.fragmentAddAccountRecyclerViewAccounts.setAdapter(accountAdapter);
    }

    //endregion

    //region Adapter listeners

    @Override
    public void onAccountItemCardViewMainContainerClickListener(Account account, int position) {

        Toast.makeText(requireActivity(), "" + account.getEmail() + account.getUsername(), Toast.LENGTH_SHORT).show();
    }
    //endregion
}