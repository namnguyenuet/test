package com.quynh.baitaplon.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.quynh.baitaplon.R;
import com.quynh.baitaplon.fragments.FragmentDangKy;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginActivity extends AppCompatActivity {
    private EditText edittk, editmk;
    private Button  btnDn, btnDk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        Anhxa();
        initEvent();
    }
    private void Anhxa()
    {
        edittk = (EditText)findViewById(R.id.edttk);
        editmk = (EditText)findViewById(R.id.edtmk);
        btnDn = (Button)findViewById(R.id.btnDangnhap);
        btnDk = (Button)findViewById(R.id.btnDK);
    }
    private void initEvent(){
        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittk.getText().toString().equals("quynh") && editmk.getText().toString().equals("quynh"))
                    intent();

            }
        });
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(R.id.danghap, FragmentDangKy.newInstance(),"Fragment Dang ky");
            }
        });
    }

    public void addFragment(@IdRes int containterID, @NonNull Fragment fragment,@NonNull String fragTag){
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(fragTag)
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out)
                .add(containterID,fragment,fragTag)
                .commitAllowingStateLoss();
    }
    private void intent(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        finish();//boqwư2 di thi back se ve lai man hinh dang nhap. ko thoat han nua
    }
}
