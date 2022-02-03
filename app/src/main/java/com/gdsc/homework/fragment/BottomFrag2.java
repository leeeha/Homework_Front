package com.gdsc.homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.gdsc.homework.R;

// 2. 통계
public class BottomFrag2 extends Fragment {

    public BottomFrag2() {}

    public static BottomFrag2 newInstance() {
        BottomFrag2 fragment = new BottomFrag2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bottom2, container, false);

        return view;
    }
}
