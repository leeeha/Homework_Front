package com.gdsc.homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gdsc.homework.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

// 1. 가사 분담
public class FirstFragment extends Fragment {

    public FirstFragment() { }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    public View rootView;

    @Override // 프래그먼트 레이아웃 인플레이트 시키고, 루트 뷰 리턴
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }

    // View의 초기값 설정 - 바인딩, RecyclerView Adapter 설정 등
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        replaceTopTab(MyTabFragment.newInstance());
        chooseTopTab();
    }

    private void chooseTopTab() {
        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    replaceTopTab(MyTabFragment.newInstance());
                }else{
                    replaceTopTab(WholeTabFragment.newInstance());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // 상단 탭 전환
    public void replaceTopTab(Fragment fragment){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.top_tab_container, fragment).commit();
    }

    // 공통: 플로팅 버튼으로 가사분담 다이얼로그 띄우기

}
