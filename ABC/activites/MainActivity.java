package com.quynh.baitaplon.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.quynh.baitaplon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean isExit = false;

    @Override
    public void onBackPressed() {

        int index = getSupportFragmentManager().getBackStackEntryCount();
        if (index > 0) {

            super.onBackPressed();
        } else {
            if (isExit) {
                finish();
            } else {
                Toast.makeText(this, "Press again to exit!",
                        Toast.LENGTH_SHORT).show();
                isExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 3 * 1000);

            }
        }

    }
}
