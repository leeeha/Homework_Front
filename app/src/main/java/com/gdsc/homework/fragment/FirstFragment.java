package com.gdsc.homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.gdsc.homework.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

// 1. 가사 분담
public class FirstFragment extends Fragment {

    public FirstFragment() { }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    private View rootView;

    @Override // 레이아웃 인플레이트 시키고, 루트 뷰 리턴
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }

    @Override // 레이아웃의 모든 뷰를 바인딩
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        chooseTabLayout();
        showCalendarView();
        showTodayList();
        showWeeklyList();
    }

    // 개인, 전체 탭 선택
    private void chooseTabLayout() {
        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout);
        ConstraintLayout myTabLayout = rootView.findViewById(R.id.myTabLayout);
        ConstraintLayout wholeTabLayout = rootView.findViewById(R.id.wholeTabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
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

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    // 주간 캘린더
    private void showCalendarView() {
        HorizontalCalendar[] calendars = new HorizontalCalendar[2];
        calendars[0] = buildCalendar(R.id.myCalendarView);
        calendars[1] = buildCalendar(R.id.wholeCalendarView);

        // 개인 탭의 주간 캘린더
        calendars[0].setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // 요일에 따라 다른 리스트 보여주기
            }
        });

        // 전체 탭의 주간 캘린더
        calendars[1].setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // 요일에 따라 다른 리스트 보여주기
            }
        });
    }

    private HorizontalCalendar buildCalendar(int viewId) {
        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        // setting up our horizontal calendar view and passing id our calendar view to it.
        return new HorizontalCalendar.Builder(requireActivity(), viewId)
                // add a range as start date and end date to our calendar.
                .range(startDate, endDate)
                // provide a number of dates which will be visible on the screen at a time.
                .datesNumberOnScreen(7)
                // at last, call a build method to build our horizontal recycler view.
                .build();
    }

    private void showTodayList(){

    }

    private void showWeeklyList(){

    }

    // 플로팅 버튼으로 가사분담 다이얼로그 띄우기

}
