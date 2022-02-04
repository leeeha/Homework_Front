package com.gdsc.homework.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdsc.homework.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class BottomFragment2_monthly extends Fragment {

    private PieChart chart;

    public BottomFragment2_monthly() {
    }

    public static BottomFragment2_monthly newInstance() {
        BottomFragment2_monthly fragment = new BottomFragment2_monthly();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bottom_fragment2_monthly, container, false);

        chart = view.findViewById(R.id.tab1_chart_1);
        setPieChart();

        return view;
    }

    private void setPieChart() {

        chart.clearChart();

        chart.addPieSlice(new PieModel("TYPE 1", 60, Color.parseColor("#CDA67F")));
        chart.addPieSlice(new PieModel("TYPE 2", 40, Color.parseColor("#00BFFF")));

        chart.startAnimation();

    }
}