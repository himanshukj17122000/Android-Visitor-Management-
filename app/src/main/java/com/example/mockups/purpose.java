package com.example.mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class purpose extends AppCompatActivity {
     EditText a,b;
     Spinner c;
     visitor purposee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthpage);
        a=findViewById(R.id.whom);
        c=findViewById(R.id.spinner);
        b=findViewById(R.id.outtime);
        purposee= (visitor)getIntent().getSerializableExtra("Visitor Info");
        if(!TextUtils.isEmpty(purposee.getWhom().trim())){
            a.setText(purposee.getWhom().toString());
            b.setText(purposee.getOuttime().toString());
        }
    }
    public void infod(View v){
        Intent i= new Intent(purpose.this, info.class);
        startActivity(i);
    }
    public void photod(View v){
        if(TextUtils.isEmpty(a.getText().toString().trim()) || TextUtils.isEmpty(b.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Please enter values in the required fields", Toast.LENGTH_SHORT).show();
        }else{

            purposee.setPurpose(c.getSelectedItem().toString());
            purposee.setWhom(a.getText().toString());
            purposee.setOuttime(b.getText().toString());
            Intent i = new Intent(purpose.this, photo.class);
            i.putExtra("Visitor Purpose", purposee);
            startActivity(i);
        }


    }
}
