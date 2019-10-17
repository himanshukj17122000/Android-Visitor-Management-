package com.example.mockups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class finalpage extends AppCompatActivity {
    MyDBHandler dbhandler;
    TextView h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);
        h=findViewById(R.id.hi);
        dbhandler = new MyDBHandler(this, null, null, 1);
        
        visitor visi = (visitor) getIntent().getSerializableExtra("Visitor Done");
        dbhandler.addRows(visi);
        printdatabase();


        printdatabase();
    }

//    public void deletbuttonclicked(View view){
//        dbhandler.deleteProduct(string value);
//        printdatabase();
//
//    }
        private void printdatabase () {
            String dbstring = dbhandler.databaseToString();
            h.setText(dbstring);

        }
    }

