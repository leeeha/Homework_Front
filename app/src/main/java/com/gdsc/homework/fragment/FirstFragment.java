package com.gdsc.homework.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.gdsc.homework.AutoChargeFragment;
import com.gdsc.homework.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

// 1. 가사 분담
public class FirstFragment extends Fragment {

    // default constructor
    public FirstFragment() { }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changePage(pos, view);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void changePage(int pos, View view) {
        ConstraintLayout myTabLayout = view.findViewById(R.id.myTabLayout);
        ConstraintLayout wholeTabLayout = view.findViewById(R.id.wholeTabLayout);

        switch (pos){
            case 0:
                myTabLayout.setVisibility(View.VISIBLE);
                wholeTabLayout.setVisibility(View.INVISIBLE);
                break;
            case 1:
                myTabLayout.setVisibility(View.INVISIBLE);
                wholeTabLayout.setVisibility(View.VISIBLE);
                break;
        }

    }
}
