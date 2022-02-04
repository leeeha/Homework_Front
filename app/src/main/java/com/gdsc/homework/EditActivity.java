package com.gdsc.homework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 카테고리: 싱글 스피너
        // 담당자: 멀티 스피너
        // 요일: 멀티 스피너
        // 리스너: 카테고리는 문자열 하나 보내기, 담당자 & 요일은 배열 보내기
        int[] spinId = { R.id.spinner_category, R.id.spinner_person, R.id.spinner_day };
        int[] arrayResId = { R.array.categories, R.array.people, R.array.week };
        int[] layoutId = { R.layout.spinner_single_item,
                R.layout.spinner_multi_item, R.layout.spinner_multi_item};

        Spinner[] spinners = new Spinner[3];

        for (int i = 0; i < 3; i++) {
            spinners[i] = initSpinnerItems(spinId[i], arrayResId[i], layoutId[i]);
        }

        // 카테고리 스피너
        spinners[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String text = spinners[0].getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                // todo: 서버에 보내기
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 담당자 스피너
        spinners[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // 체크 표시된 모든 아이템들의 텍스트를 가져와서
                String text = spinners[1].getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                // todo: 서버에 보내기

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 요일 스피너
        spinners[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String text = spinners[2].getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                // todo: 서버에 보내기
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Spinner initSpinnerItems(int spinId, int arrayResId, int layoutId) {
        Spinner spinner = findViewById(spinId);
        String[] array = getResources().getStringArray(arrayResId);

        ArrayAdapter<String> adapter;

        if(layoutId == R.layout.spinner_single_item){
               adapter = new ArrayAdapter<String>(this, layoutId, array) {
                   @Override
                   public boolean isEnabled(int position) {
                       if (position == 0) {
                           // Disable the first item from Spinner
                           // First item will be use for hint
                           return false;
                       } else {
                           return true;
                       }
                   }

                   @Override
                   public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                       View view = super.getDropDownView(position, convertView, parent);
                       TextView tv = (TextView) view;
                       if (position == 0) {
                           // Set the hint text color gray
                           tv.setTextColor(Color.GRAY);
                       } else {
                           tv.setTextColor(Color.BLACK);
                       }
                       return view;
                   }};
           } else{
                // 스피너의 텍스트뷰에 대한 리소스 아이디를 어댑터에게 전달해줘야
                // 어댑터가 배열의 내용을 텍스트뷰에 적용 가능!
                adapter = new ArrayAdapter<String>(this, layoutId, R.id.tv_spinner, array){
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv_spinner = view.findViewById(R.id.tv_spinner);
                        CheckBox checkBox = view.findViewById(R.id.checkbox);

                        if (position == 0) {
                            // Set the hint text color gray
                            tv_spinner.setTextColor(Color.GRAY);
                        } else {
                            tv_spinner.setTextColor(Color.BLACK);
                            checkBox.setVisibility(View.VISIBLE);
                        }
                        return view;
                    }};
            }

        spinner.setAdapter(adapter);

        return spinner;
    }
}