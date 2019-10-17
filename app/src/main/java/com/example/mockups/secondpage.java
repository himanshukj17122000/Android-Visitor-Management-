package com.example.mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class secondpage extends AppCompatActivity {
    visitor vis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick(View v){
        vis= new visitor();
        Intent i= new Intent(secondpage.this, phoonelogin.class);
        i.putExtra("New Visitor",  vis);
        startActivity(i);
    }
}
