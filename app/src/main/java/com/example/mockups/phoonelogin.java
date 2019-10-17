package com.example.mockups;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class phoonelogin extends AppCompatActivity implements phoone.OnFragmentInteractionListener, email.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonenumberpage);
        // Capture the layout's TextView and set the string as its text
        final TabLayout tabLayout= findViewById(R.id.tabl);
        tabLayout.addTab(tabLayout.newTab().setText("Phone Number"));
        tabLayout.addTab(tabLayout.newTab().setText("Email ID"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager= findViewById(R.id.pager);
        final PagerAdapter adapter= new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void onClick(View v){
        visitor book= (visitor)getIntent().getSerializableExtra("New Visitor");

        Intent i= new Intent(phoonelogin.this, bookingid.class);
        i.putExtra("Booking ID", book);
        startActivity(i);
    }

}