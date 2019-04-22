package com.quynh.baitaplon.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.quynh.baitaplon.R;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDKday extends BaseFragment{

    private ImageView imgBack;
    private Button btnDKday;

    public static FragmentDKday newInstance(){
        Bundle args = new Bundle();
        FragmentDKday dKday = new FragmentDKday();
        dKday.setArguments(args);
        return dKday;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initID();
        initEvent();
    }

    private void initID(){
        imgBack = view.findViewById(R.id.imgBack);
        btnDKday =view.findViewById(R.id.btnDkday);
    }

    private void initEvent(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        btnDKday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(R.id.main, FragmentCongViec.newInstance(),"Fragment CV");
            }
        });
    }
    private  void addFragment(@IdRes int containterID, @NonNull Fragment fragment, @NonNull String fragTag){
        getChildFragmentManager().beginTransaction()
                .addToBackStack(fragTag)
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out)
                .add(containterID,fragment,fragTag)
                .commitAllowingStateLoss();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.main;
    }

}

