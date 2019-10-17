package com.example.mockups;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    private static int TIME=4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent= new Intent(MainActivity.this,secondpage.class);
                startActivity(homeintent);
                finish();
            }
        }, TIME);

    }


}

