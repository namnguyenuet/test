package com.quynh.baitaplon.fragments;

import android.os.Bundle;
import android.view.View;

import com.quynh.baitaplon.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentCongViec extends BaseFragment {

    public static FragmentCongViec newInstance(){
        Bundle args = new Bundle();
        FragmentCongViec cb = new FragmentCongViec();
        cb.setArguments(args);
        return cb;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.cv;
    }
}
