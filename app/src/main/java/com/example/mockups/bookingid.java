package com.example.mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class bookingid extends AppCompatActivity {
    EditText t;
    MyDBHandler d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode);
        t=findViewById(R.id.editt);
    }
    public void onClick4(View v){
        if(TextUtils.isEmpty(t.getText().toString().trim())){
            // Toast.makeText(getApplicationContext(),"Please enter a valid booking ID", Toast.LENGTH_SHORT).show();
            t.setError("This is a required field");

        }
        else{
//            if(d.Exists(t.getText().toString())) {
//                visitor present = d.present(t.getText().toString());
//                Intent i = new Intent(bookingid.this, type.class);
//                i.putExtra("Visitor Present", present);
//                startActivity(i);
//            }
//            else {
                visitor book= (visitor)getIntent().getSerializableExtra("Booking ID");
                book.setId(t.getText().toString());
                Intent i= new Intent(bookingid.this, type.class);
                i.putExtra("Visitor Phone", book);
                startActivity(i);
            }

//        }

    }
    public void onClick5(View v){
        finish();

    }

}
