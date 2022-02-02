package com.gdsc.homework.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdsc.homework.AutoChargeFragment;
import com.gdsc.homework.MainActivity;
import com.gdsc.homework.R;

// pay
public class FourthFragment extends Fragment implements View.OnClickListener {

    private TextView tv_autocharge, tv_normalcharge, tv_transfer, tv_usagehistory;

    public FourthFragment() {}

    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fourth, container, false);

        tv_autocharge = view.findViewById(R.id.tv_autocharge);
        tv_normalcharge = view.findViewById(R.id.tv_normalcharge);
        tv_transfer = view.findViewById(R.id.tv_transfer);
        tv_usagehistory = view.findViewById(R.id.tv_usagehistory);

        tv_autocharge.setOnClickListener(this);
        tv_normalcharge.setOnClickListener(this);
        tv_transfer.setOnClickListener(this);
        tv_usagehistory.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tv_autocharge:
                ((MainActivity)getActivity()).replaceFragment(AutoChargeFragment.newInstance());
                break;
            case R.id.tv_normalcharge:
                break;
            case R.id.tv_transfer:
                break;
            case R.id.tv_usagehistory:
                break;
        }
    }
}