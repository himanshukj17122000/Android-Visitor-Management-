package com.example.mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class info extends AppCompatActivity {
   EditText t,u,addn,addr,addp;
   EditText comp;
   CheckBox o;
   LinearLayout n;
   visitor info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage);
        t=findViewById(R.id.name);
        u=findViewById(R.id.address);
        comp=findViewById(R.id.company);
        addn=findViewById(R.id.addname);
        addr=findViewById(R.id.addrel);
        addp=findViewById(R.id.addphone);
        o=findViewById(R.id.additional);
        n=findViewById(R.id.add);
        info= (visitor)getIntent().getSerializableExtra("Visitor Type");
        if(!TextUtils.isEmpty(info.getName().toString().trim())){
            t.setText(info.getName().toString());
            u.setText(info.getAddress().toString());
            comp.setText(info.getCompanyname().toString());
        }

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t= n.getVisibility();
                if(t==0){
                    n.setVisibility(n.INVISIBLE);
                }else {
                    n.setVisibility(n.VISIBLE);
                }
            }
        });


    }

    public void typed(View v){
        finish();
//        Intent i= new Intent(info.this,type.class);
//        startActivity(i);
    }
    public void purposed(View v){
        if(TextUtils.isEmpty(t.getText().toString().trim()) || TextUtils.isEmpty(u.getText().toString().trim()) || TextUtils.isEmpty(comp.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Please enter values in the required fields", Toast.LENGTH_SHORT).show();

        }else {

            info.setName(t.getText().toString());
            info.setAddress(u.getText().toString());
            info.setCompanyname(comp.getText().toString());
            if (o.isChecked()){
                info.setAddname(addn.getText().toString());
                info.setAddrel(addr.getText().toString());
                info.setAddphone(addp.getText().toString());
            }
            Intent i = new Intent(info.this, purpose.class);
            i.putExtra("Visitor Info", info);
            startActivity(i);
        }

    }

}
