package com.gdsc.homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gdsc.homework.adapter.CustomAdapter;
import com.gdsc.homework.fragment.FirstFragment;
import com.gdsc.homework.fragment.FourthFragment;
import com.gdsc.homework.fragment.SecondFragment;
import com.gdsc.homework.fragment.ThirdFragment;
import com.gdsc.homework.model.Person;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(FirstFragment.newInstance());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.chores:
                    replaceFragment(FirstFragment.newInstance());
                    return true;
                case R.id.chart:
                    replaceFragment(SecondFragment.newInstance());
                    return true;
                case R.id.community:
                    replaceFragment(ThirdFragment.newInstance());
                    return true;
                case R.id.money:
                    replaceFragment(FourthFragment.newInstance(false));
                    return true;
            }
            return false;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment).commit();
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