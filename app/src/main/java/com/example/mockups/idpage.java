package com.example.mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class idpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idpage);
    }

    public void finish(View v){
        visitor id= (visitor)getIntent().getSerializableExtra(" Visitor Photo");
        Intent i= new Intent(idpage.this,finalpage.class);
        i.putExtra("Visitor Done", id);
        startActivity(i);
    }
    public void back(View v){
        Intent i= new Intent(idpage.this,photo.class);
        startActivity(i);
    }
}
