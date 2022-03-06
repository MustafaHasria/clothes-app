package com.example.clothes_app.view.dashboard;

import static com.example.clothes_app.app.AppConst.FRAGMENT_ACCOUNT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clothes_app.R;
import com.example.clothes_app.databinding.FragmentDashboardBinding;
import com.example.clothes_app.view.account.AccountFragment;

import java.util.Locale;

public class DashboardFragment extends Fragment {

    //region Variables
    FragmentDashboardBinding binding;
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        binding = FragmentDashboardBinding.bind(view);

        binding.fragmentDashboardCardViewAccount.setOnClickListener(view1 -> {
            AccountFragment accountFragment = new AccountFragment();

            FragmentTransaction fragmentTransaction =
                    getActivity().getSupportFragmentManager().beginTransaction();

            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
                    .add(R.id.activity_main_frame_layout_main_container, accountFragment, FRAGMENT_ACCOUNT)
                    .addToBackStack("DASHBOARD_FRAGMENT")
                    .commit();
        });
        Locale[] locales = Locale.getAvailableLocales();
        return binding.getRoot();
    }
}