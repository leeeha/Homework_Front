package com.gdsc.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hootsuite.nachos.NachoTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 카테고리: 싱글 스피너 (직접 입력은 일단 하지 말자. 딴 걸 먼저 하자.)
        String[] categories = { "청소", "요리", "세탁", "육아" };
        Spinner spinCategory = findViewById(R.id.spinner_category);
        ArrayAdapter<String> cateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, categories);
        spinCategory.setAdapter(cateAdapter);
        spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String catogory = categories[pos];

                // todo: 서버에 데이터 보내기

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // 담당자 (텍스트 자동완성)
        NachoTextView tvNacho = findViewById(R.id.tvNacho);
        String[] people = new String[] { "하은", "정후", "진아", "혁준" };
        ArrayAdapter<String> personAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, people);
        tvNacho.setAdapter(personAdapter);



        // 요일: 멀티 스피너

        // 반복 여부
        SwitchCompat switchRepeat = findViewById(R.id.switchRepeat);
        if(switchRepeat.isChecked()){
            // 선택한 요일이 매주 반복되도록


        }else{
            // 이번 주에만 적용

        }

        // 마감 시간

        // 벌금 여부

        // 메모

        // 입력 취소 버튼
        ImageButton btnClose = findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 창 열기 전으로 돌아가기 (가사 분담 화면)
            }
        });

        // 입력 저장 버튼

    }
}