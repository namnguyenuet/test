package com.quynh.baitaplon.fragments;

import android.os.Bundle;
import android.view.View;

import com.quynh.baitaplon.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentGT extends BaseFragment {

    public static FragmentGT newInstance(){
        Bundle args = new Bundle();
        FragmentGT gt = new FragmentGT();
        gt.setArguments(args);
        return gt;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gioithieu;
    }
}
