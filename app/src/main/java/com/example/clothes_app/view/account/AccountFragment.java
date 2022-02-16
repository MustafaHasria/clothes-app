package com.example.clothes_app.view.account;

import static com.example.clothes_app.app.AppConst.ADDRESS;
import static com.example.clothes_app.app.AppConst.EMAIL;
import static com.example.clothes_app.app.AppConst.FRAGMENT_ACCOUNT;
import static com.example.clothes_app.app.AppConst.FRAGMENT_ADD_AND_EDIT_ACCOUNT;
import static com.example.clothes_app.app.AppConst.GENDER;
import static com.example.clothes_app.app.AppConst.ID;
import static com.example.clothes_app.app.AppConst.ID_ACCOUNT_TYPE;
import static com.example.clothes_app.app.AppConst.PASSWORD;
import static com.example.clothes_app.app.AppConst.PICTURE;
import static com.example.clothes_app.app.AppConst.USERNAME;

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
import com.example.clothes_app.view.account.addaccount.AddAndEditAccountFragment;

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
            moveToAddAndEditFragment(new AddAndEditAccountFragment());
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

    }

    @Override
    public void onLongAccountItemCardViewMainContainerClickListener(Account account, int position) {
        Bundle bundle = new Bundle();
        bundle.putString(EMAIL, account.getEmail());
        bundle.putString(USERNAME, account.getUsername());
        bundle.putString(PASSWORD, account.getPassword());
        bundle.putByteArray(PICTURE, account.getPicture());
        bundle.putString(ADDRESS, account.getCountry());
        bundle.putBoolean(GENDER, account.isGender());
        bundle.putInt(ID, account.getId());
        bundle.putInt(ID_ACCOUNT_TYPE, account.getIdAccountType());
        AddAndEditAccountFragment addAndEditAccountFragment = new AddAndEditAccountFragment();
        addAndEditAccountFragment.setArguments(bundle);
        moveToAddAndEditFragment(addAndEditAccountFragment);
    }
    //endregion

    //region Methods
    private void moveToAddAndEditFragment(AddAndEditAccountFragment addAndEditAccountFragment){
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out,android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.activity_main_frame_layout_main_container, addAndEditAccountFragment, FRAGMENT_ADD_AND_EDIT_ACCOUNT)
                .addToBackStack(FRAGMENT_ACCOUNT)
                .commit();
    }
    //endregion
}