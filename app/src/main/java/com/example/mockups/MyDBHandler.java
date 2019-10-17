package com.example.mockups;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "visitor.db";
    private static final String TABLE_PRODUCTS = "visitors";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PRODUCTNAME = "Name";
    private static final String COLUMN_PHONE = "Phone";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_BOOKING = "BookingID";
    private static final String COLUMN_TYPE = "Type";
    private static final String COLUMN_ADDRESS = "Address";
    private static final String COLUMN_COMPANY = "Company";
    private static final String COLUMN_ADDNAME = "AddName";
    private static final String COLUMN_RELATION = "Relation";
    private static final String COLUMN_ADDPHONE = "AddNumber";
    private static final String COLUMN_PURPOSE = "PurposeVisit";
    private static final String COLUMN_WHOM = "WhomMeet";
    private static final String COLUMN_OUT = "OutTime";
    private static final String COLUMN_PHOTO = "VisitorPhoto";
    private final String[] COLUMNS ={COLUMN_ID,COLUMN_PRODUCTNAME,COLUMN_PHONE,COLUMN_EMAIL,COLUMN_BOOKING, COLUMN_TYPE, COLUMN_ADDRESS, COLUMN_COMPANY, COLUMN_ADDNAME, COLUMN_RELATION, COLUMN_ADDPHONE, COLUMN_PURPOSE, COLUMN_WHOM, COLUMN_OUT, COLUMN_PHOTO};

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_BOOKING + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_COMPANY + " TEXT, " +
                COLUMN_ADDNAME + " TEXT, " +
                COLUMN_RELATION + " TEXT, " +
                COLUMN_ADDPHONE + " TEXT, " +
                COLUMN_PURPOSE + " TEXT, " +
                COLUMN_WHOM + " TEXT, " +
                COLUMN_OUT + " TEXT, " +
                COLUMN_PHOTO + " BLOB " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
    }

    //Add a new row to the database

    public void addRows(visitor v) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, v.getName());
        values.put(COLUMN_PHONE, v.getPhoneem());
        values.put(COLUMN_TYPE, v.getType());
        values.put(COLUMN_PURPOSE, v.getPurpose());
        values.put(COLUMN_ADDRESS, v.getAddress());
        values.put(COLUMN_ADDNAME, v.getAddname());
        values.put(COLUMN_ADDPHONE, v.getAddphone());
        values.put(COLUMN_RELATION, v.getAddrel());
        values.put(COLUMN_COMPANY, v.getCompanyname());
        values.put(COLUMN_WHOM, v.getWhom());
        values.put(COLUMN_OUT, v.getOuttime());
        values.put(COLUMN_PHOTO, v.getPhoto());
        values.put(COLUMN_EMAIL, v.getEmail());
        values.put(COLUMN_BOOKING, v.getId());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);
        sqLiteDatabase.close();


    }

    public void modRows(visitor v) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, v.getName());
        values.put(COLUMN_PHONE, v.getPhoneem());
        values.put(COLUMN_TYPE, v.getType());
        values.put(COLUMN_PURPOSE, v.getPurpose());
        values.put(COLUMN_ADDRESS, v.getAddress());
        values.put(COLUMN_ADDNAME, v.getAddname());
        values.put(COLUMN_ADDPHONE, v.getAddphone());
        values.put(COLUMN_RELATION, v.getAddrel());
        values.put(COLUMN_COMPANY, v.getCompanyname());
        values.put(COLUMN_WHOM, v.getWhom());
        values.put(COLUMN_OUT, v.getOuttime());
        values.put(COLUMN_PHOTO, v.getPhoto());
        values.put(COLUMN_EMAIL, v.getEmail());
        values.put(COLUMN_BOOKING, v.getId());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update(TABLE_PRODUCTS,values,COLUMN_ID + " = ?",
                new String[]{v.getPhoneem()});
        sqLiteDatabase.close();
    }

    public visitor present(String phone){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.query(TABLE_PRODUCTS, COLUMNS, COLUMN_PHONE +" = ?",
                new String[]{String.valueOf(phone)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        visitor contact= new visitor();
        contact.setName(cursor.getString(1));
        contact.setPhoneem(cursor.getString(2));
        contact.setEmail(cursor.getString(3));
        contact.setId(cursor.getString(4));
        contact.setType(cursor.getString(5));
        contact.setAddress(cursor.getString(6));
        contact.setCompanyname(cursor.getString(7));
        contact.setWhom(cursor.getString(12));
        contact.setOuttime(cursor.getString(13));
        return contact;

    }



    //Delete a row from the database

    public void deleteProduct(String productName) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(" DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
    }

    //Print out the database as a string
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";
        //Cursor point to a location in your results
        Cursor c= sqLiteDatabase.rawQuery(query,null);
        //move to the first row in your results
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("Name")) != null) {
                dbString += c.getString(c.getColumnIndex("Name"));
                dbString+="\t";
                dbString+=c.getString(c.getColumnIndex("Phone"));
                dbString+="\t";
                dbString+=c.getString(c.getColumnIndex("Email"));
                dbString+="\t";
                dbString+=c.getString(c.getColumnIndex("BookingID"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        sqLiteDatabase.close();
        return dbString;

    }


    public boolean Exists(String searchItem) {
        String[] columns = {COLUMN_PRODUCTNAME };
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String selection = COLUMN_PRODUCTNAME + " =?";
        String[] selectionArgs = { searchItem };
        String limit = "1";
        Cursor cursor = sqLiteDatabase.query(DATABASE_NAME, columns, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

   }
