package com.gdsc.homework.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdsc.homework.R;

// 3. 커뮤니티, 전문가 상담
public class BottomFrag3 extends Fragment {

    public BottomFrag3() {}

    public static BottomFrag3 newInstance() {
        BottomFrag3 fragment = new BottomFrag3();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bottom3, container, false);

        return view;
    }
}