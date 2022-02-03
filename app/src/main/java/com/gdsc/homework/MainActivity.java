package com.gdsc.homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.gdsc.homework.fragment.FirstFragment;
import com.gdsc.homework.fragment.FourthFragment;
import com.gdsc.homework.fragment.SecondFragment;
import com.gdsc.homework.fragment.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 하단 탭
        replaceBottomTab(FirstFragment.newInstance());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.chores:
                    replaceBottomTab(FirstFragment.newInstance());
                    return true;
                case R.id.chart:
                    replaceBottomTab(SecondFragment.newInstance());
                    return true;
                case R.id.community:
                    replaceBottomTab(ThirdFragment.newInstance());
                    return true;
                case R.id.money:
                    replaceBottomTab(FourthFragment.newInstance(false));
                    return true;
            }
            return false;
        }
    }

    // 하단 탭 전환
    public void replaceBottomTab(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottom_nav_container, fragment).commit();
    }

    public void setVisibilityBottomNavigation(boolean type) {
        // todo : 조금 더 부드럽게 동작하게 하기 위해 slide animation 고려 가능
        if (type) {
            bottomNavigationView.setVisibility(View.VISIBLE);
        } else {
            bottomNavigationView.setVisibility(View.GONE);
        }
    }
}