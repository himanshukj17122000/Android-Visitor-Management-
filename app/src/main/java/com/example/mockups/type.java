package com.example.mockups;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class type extends AppCompatActivity  {
     RadioButton a,b,c,d,e,l;
     RadioGroup g;
     EditText f;
     visitor check;


String twmpValue ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);
        g=findViewById(R.id.type);
        a=findViewById(R.id.management);
        b=findViewById(R.id.client);
        c=findViewById(R.id.candidates);
        f=findViewById(R.id.other);
        d=findViewById(R.id.others);
        e=findViewById(R.id.guests);

         check= (visitor)getIntent().getSerializableExtra("Visitor Present");
        if(check!=null){
            String a= check.getType();
            if(a=="Management"){
                this.a.isChecked();
                twmpValue="Management";
            }
            else if(a=="Client"){
                this.b.isChecked();
                twmpValue="Client";
            }
            else if(a=="Candidates"){
                this.c.isChecked();
                twmpValue="Management";
            }
            else if(a=="Guests"){
                this.e.isChecked();
                twmpValue="Guests";
            }
            else{
                d.isChecked();
            }

        } else{
            check= (visitor)getIntent().getSerializableExtra("Visitor Phone");
        }

        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    twmpValue = "Management";
                }
            }
        });
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ty) {
                if (ty){
                    twmpValue = "Client";
                }
            }
        });
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    twmpValue = "Candidates";
                }
            }
        });
        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    twmpValue=f.getText().toString();
                }
            }
        });
        e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    twmpValue = "Guests";
                }
            }
        });



    }

    public void login(View v){

        finish();
        //Intent i= new Intent(type.this,phoonelogin.class);
        //startActivity(i);

    }
    public void infodd(View v){

        if (a.isChecked() || b.isChecked() || c.isChecked() || e.isChecked() || (d.isChecked() && !f.getText().toString().matches(""))){


            check.setType(twmpValue);
            Intent i= new Intent(type.this,info.class);
            i.putExtra("Visitor Type", check);
            startActivity(i);

        }
        else{
            Toast.makeText(getApplicationContext(),"Please choose one of the options", Toast.LENGTH_SHORT).show();

        }


    }


}
