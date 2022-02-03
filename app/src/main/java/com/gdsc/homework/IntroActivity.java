package com.gdsc.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_createroom, tv_joinroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tv_createroom = findViewById(R.id.tv_createroom);
        tv_joinroom = findViewById(R.id.tv_joinroom);
        tv_createroom.setOnClickListener(this);
        tv_joinroom.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_createroom:
                break;
            case R.id.tv_joinroom:
                break;
        }
    }
}