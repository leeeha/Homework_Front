package com.gdsc.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 카테고리 선택
        String[] categories = { "청소", "요리", "세탁", "육아", "직접 입력" };
        AutoCompleteTextView tvCategory = findViewById(R.id.tv_category);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.option_item_text, categories);
        tvCategory.setAdapter(adapter);

        // 담당자 선택 (중복 선택 가능하도록 커스텀하기)
        String[] people = { "하은", "정후", "진아", "혁준" };
        AutoCompleteTextView tvPerson = findViewById(R.id.tv_person);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.option_item_text, people);
        tvPerson.setAdapter(adapter2);

        // 요일 선택 (중복 선택 가능하도록 커스텀하기)
        String[] week = { "월", "화", "수", "목", "토", "일" };
        AutoCompleteTextView tvDay = findViewById(R.id.tv_day);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, R.layout.option_item_text, week);
        tvDay.setAdapter(adapter3);

        // 반복 여부
        SwitchCompat switchRepeat = findViewById(R.id.switchRepeat);
        if(switchRepeat.isChecked()){
            // 위에서 선택한 카테고리, 담당자, 요일 -> 매주 반복
            Toast.makeText(this, "반복", Toast.LENGTH_SHORT).show();
        }else{

        }

        // 시간 지정 여부
        SwitchCompat switchTime = findViewById(R.id.switchTime);
        ConstraintLayout optionalLayout1 = findViewById(R.id.optionalLayout1);
        if(switchTime.isChecked()){
            optionalLayout1.setVisibility(View.VISIBLE);
        }else{
            optionalLayout1.setVisibility(View.GONE);
        }

        // 벌금 여부
        SwitchCompat switchPenalty = findViewById(R.id.switchPenalty);
        ConstraintLayout optionalLayout2 = findViewById(R.id.optionalLayout2);
        if(switchPenalty.isChecked()){
            optionalLayout2.setVisibility(View.VISIBLE);
        }else{
            optionalLayout2.setVisibility(View.GONE);
        }

        // 메모
        TextInputEditText edtMemo = findViewById(R.id.edtMemo);
        String memo = Objects.requireNonNull(edtMemo.getText()).toString();
        // 개인, 전체 탭의 리사이클러뷰에 모두 메모 보여주기

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