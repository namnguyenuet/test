package com.quynh.baitaplon.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.quynh.baitaplon.R;
import com.quynh.baitaplon.fragments.FragmentDangKy;
import com.quynh.baitaplon.fragments.FragmentGT;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity {

    private Button btnLog,btnSign,btnGT;

    private MainActivity mainActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        init();
        initView();
    }
    private  void init(){
        btnLog = findViewById(R.id.btnLog);
        btnSign = findViewById(R.id.btnSign);
        btnGT = findViewById(R.id.btnGT);

    }
    private void initView(){
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));

            }
        });
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(R.id.home, FragmentDangKy.newInstance(),FragmentDangKy.class.getName());
            }
        });
        btnGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(R.id.home, FragmentGT.newInstance(), FragmentGT.class.getName());
            }
        });
    }

    public void addFragment(@IdRes int containterID, @NonNull Fragment fragment, @NonNull String fragTag){
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(fragTag)
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out)
                .add(containterID,fragment,fragTag)
                .commitAllowingStateLoss();
    }
}
