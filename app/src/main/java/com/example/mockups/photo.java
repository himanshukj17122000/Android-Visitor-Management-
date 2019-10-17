package com.example.mockups;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class photo extends AppCompatActivity {
   ImageView jj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoscreen);
        jj=findViewById(R.id.pooo);


    }

    public void Inee(View v){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
   public void BookingID(View v){
       finish();

   }
   public void ID(View v){
        if(jj.getDrawable()==null){
            Toast.makeText(getApplicationContext(),"Please take a picture",Toast.LENGTH_SHORT).show();
        }else{
            visitor photo= (visitor)getIntent().getSerializableExtra("Visitor Purpose");
            Drawable d= jj.getDrawable();
            Bitmap bit= ((BitmapDrawable)d).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bitMapData = stream.toByteArray();
            photo.setPhoto(bitMapData);
            Intent io= new Intent(photo.this,idpage.class);
            io.putExtra(" Visitor Photo", photo);
            startActivity(io);
        }

   }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap= (Bitmap) data.getExtras().get("data");
        jj.setImageBitmap(bitmap);
    }
}
