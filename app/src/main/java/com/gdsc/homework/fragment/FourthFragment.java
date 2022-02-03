package com.gdsc.homework.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdsc.homework.AutoChargeFragment;
import com.gdsc.homework.MainActivity;
import com.gdsc.homework.PayFragment;
import com.gdsc.homework.R;

// 4. 저금통
public class FourthFragment extends Fragment implements View.OnClickListener {

    private TextView tv_autocharge, tv_normalcharge, tv_transfer, tv_usagehistory;

    private static final String ARG_PARAM = "param";
    private boolean mIsLottieAnimStart;

    public FourthFragment() {}

    public static FourthFragment newInstance(boolean isAfterPayActivity) {
        FourthFragment fragment = new FourthFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM, isAfterPayActivity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIsLottieAnimStart = getArguments().getBoolean(ARG_PARAM);
        }
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

        // todo : mIsLottieAnimStart 에 따라 애니메이션 구동

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tv_autocharge:
                ((MainActivity) requireActivity()).replaceFragment(AutoChargeFragment.newInstance());
                ((MainActivity) requireActivity()).setVisibilityBottomNavigation(false);
                break;
            case R.id.tv_normalcharge:
                break;
            case R.id.tv_transfer:
                ((MainActivity)getActivity()).replaceFragment(PayFragment.newInstance("정후네 가족", "룰렛 이용료", 10000));
                ((MainActivity)getActivity()).setVisibilityBottomNavigation(false);
                break;
            case R.id.tv_usagehistory:
                break;
        }
    }
}