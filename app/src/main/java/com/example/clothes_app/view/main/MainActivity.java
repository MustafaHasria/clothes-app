package com.example.clothes_app.view.main;

import static com.example.clothes_app.app.AppConst.FRAGMENT_DASHBOARD;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.clothes_app.R;
import com.example.clothes_app.view.dashboard.DashboardFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DashboardFragment dashboardFragment = new DashboardFragment();

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();

        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.activity_main_linear_layout_main_container, dashboardFragment, FRAGMENT_DASHBOARD)
                .commit();
    }
}