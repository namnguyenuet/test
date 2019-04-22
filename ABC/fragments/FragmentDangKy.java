package com.quynh.baitaplon.fragments;


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
    DatabaseHelper database;
    private  EditText txtname,  txtpass,txtcfpass,txtphone, txtbirthday;
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
        database = new DatabaseHelper (getActivity());
        initID();
        initEvent();

    }

    private void initID(){
        imgBack = view.findViewById(R.id.imgBack);
        btnDangKy =view.findViewById(R.id.btnDangky);
        txtname = view.findViewById(R.id.tk);
        txtpass = view.findViewById(R.id.dkmk);
        txtcfpass =view.findViewById (R.id.cfmk);
        txtphone = view.findViewById(R.id.sdt);
        txtbirthday = view.findViewById(R.id.namsinh);
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
                String cfpass= txtcfpass.getText().toString();
                String phone= txtphone.getText().toString();
                String birth= txtbirthday.getText ().toString ();
                if (name.equals("")||pass.equals("")||cfpass.equals("")||phone.equals("")||birth.equals(""))
                {
                    Toast.makeText(getActivity().getApplicationContext (),"Điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(cfpass))
                    {
                        Boolean checkName = database.checkname(name);
                        if (checkName==true)
                        {
                            Boolean insert = database.insert(name,pass,phone,birth);
                            if (insert==true)
                            {
                                Toast.makeText(getActivity().getApplicationContext (),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getActivity().getApplicationContext (),"Name đã tồn tại",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getActivity().getApplicationContext (), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        );


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


