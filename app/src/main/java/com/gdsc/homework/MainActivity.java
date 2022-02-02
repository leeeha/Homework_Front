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

    RecyclerView recyclerView;
    CustomAdapter adapter;
    boolean isLinearLayoutManager = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(FirstFragment.newInstance());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        // 리사이클러뷰 세팅
        ArrayList<Person> family = new ArrayList<Person>() {{
            add(new Person("이형근", "아빠", new ArrayList<>(Arrays.asList("분리수거", "음식물 쓰레기"))));
            add(new Person("손선영", "엄마", new ArrayList<>(Arrays.asList("요리", "청소"))));
            add(new Person("이다은", "첫째 딸", new ArrayList<>(Arrays.asList("방청소", "설거지"))));
            add(new Person("이하은", "둘째 딸", new ArrayList<>(Arrays.asList("방청소", "세탁", "설거지"))));
        }};

        recyclerView = findViewById(R.id.recycler_view);
        chooseLayout();
        adapter = new CustomAdapter(family);
        recyclerView.setAdapter(adapter);
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

    private void chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }

    private void setIcon(MenuItem item) {
        if (item == null) return;
        if (isLinearLayoutManager) item.setIcon(R.drawable.ic_grid_layout);
        else item.setIcon(R.drawable.ic_linear_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)    {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        MenuItem layoutButton = menu.findItem(R.id.layout);
        setIcon(layoutButton);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.layout:
                isLinearLayoutManager = !isLinearLayoutManager;
                chooseLayout();
                setIcon(item);
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "설정", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment).commit();
    }
}