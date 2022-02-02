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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(FirstFragment.newInstance());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
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
                    replaceFragment(FourthFragment.newInstance());
                    //transaction.replace(R.id.flFragment, fourthFragment).commitAllowingStateLoss();
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
}