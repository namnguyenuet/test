package com.quynh.baitaplon.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.quynh.baitaplon.DatabaseHelper;
import com.quynh.baitaplon.R;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDangKy extends BaseFragment{
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText txtname,  txtpass,txtphone, txtbirthday;
    private ImageView imgBack;
    private Button btnDangKy;

    public static FragmentDangKy newInstance(){
        Bundle args = new Bundle();
        FragmentDangKy dangKy = new FragmentDangKy();
        dangKy.setArguments(args);
        return dangKy;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openHelper = new DatabaseHelper (this);
        initID();
        initEvent();

    }

    private void initID(){
        imgBack = view.findViewById(R.id.imgBack);
        btnDangKy =view.findViewById(R.id.btnDangky);
        txtname = view.findViewById(R.id.tk);
        txtpass = view.findViewById(R.id.dkmk);
        txtphone = view.findViewById(R.id.sdt);
        txtphone = view.findViewById(R.id.namsinh);
    }

    private void initEvent(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=  txtname.getText().toString();
                String pass= txtpass.getText().toString();
                String phone= txtphone.getText().toString();
                String birth= txtbirthday.getText ().toString ();

            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(R.id.dangky, FragmentCongViec.newInstance(),"Fragment CV");
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
        return R.layout.dangky;
    }

}

