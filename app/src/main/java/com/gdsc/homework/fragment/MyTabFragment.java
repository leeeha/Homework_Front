package com.gdsc.homework.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdsc.homework.R;
import com.gdsc.homework.adapter.MyAdpater;
import com.gdsc.homework.adapter.TodoAdapter;
import com.gdsc.homework.model.MyChores;
import com.gdsc.homework.model.ToDo;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MyTabFragment extends Fragment {
    private View rootView;

    public MyTabFragment() {
        // Required empty public constructor
    }

    public static MyTabFragment newInstance() {
        MyTabFragment fragment = new MyTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // 프래그먼트 레이아웃 인플레이트
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_my_tab, container, false);
        return rootView;
    }

    @Override // 뷰 바인딩, 어댑터 등 초기화 작업
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showMyCalendar(R.id.myCalendarView);
        showTodoList();
        showMyList();
        // 플로팅 버튼
    }

    // list_item_todo
    private void showTodoList() {
        ArrayList<ToDo> dataSet = new ArrayList<ToDo>() {{
            add(new ToDo("설거지", R.drawable.ic_launcher_background));
            add(new ToDo("세탁", R.drawable.ic_launcher_background));
            add(new ToDo("요리", R.drawable.ic_launcher_background));
        }};

        RecyclerView todoRecyclerView = rootView.findViewById(R.id.todoList);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        todoRecyclerView.setAdapter(new TodoAdapter(dataSet));
    }

    // list_item_mine
    private void showMyList() {
        ArrayList<MyChores> dataSet = new ArrayList<MyChores>() {{
            add(new MyChores("세탁", "월 화 수 (오후 10시)"));
            add(new MyChores("설거지", "목 금 토 (수시로)"));
            add(new MyChores("화장실 청소", "일 (오후 2시)"));
        }};

        RecyclerView myRecyclerView = rootView.findViewById(R.id.myList);

        // 레이아웃 매니저, 어댑터 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);
        MyAdpater adapter = new MyAdpater(dataSet);
        myRecyclerView.setAdapter(adapter);

        // 구분선 추가
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(myRecyclerView.getContext(),
                layoutManager.getOrientation());
        myRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    // 공통: 주간 캘린더
    public void showMyCalendar(int viewId) {
        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        // setting up our horizontal calendar view and passing id our calendar view to it.

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(requireActivity(), viewId)
                // add a range as start date and end date to our calendar.
                .range(startDate, endDate)
                // provide a number of dates which will be visible on the screen at a time.
                .datesNumberOnScreen(7)
                .configure()
                .showTopText(false)
                .end()
                // at last, call a build method to build our horizontal recycler view.
                .build();

        // 선택된 날짜에 따라 다른 리스트 보여주기
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // 요일에 따라 다른 리스트 보여주기

            }
        });
    }
}