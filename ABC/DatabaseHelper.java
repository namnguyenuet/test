package com.quynh.baitaplon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(Context context) {
        super(context, "dangnhap.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("Create table user(name text primary key, pass text , phone text, birth text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //inserting in database
    public boolean insert(String name, String pass, String phone, String birth )
    {
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",pass);
        contentValues.put("phone", phone);
        contentValues.put("birth", birth);
        long ins = database.insert("user",null, contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //checking if email exists
    public Boolean checkname(String name)
    {
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor=database.rawQuery("Select * from user where name=?",new String[]{name});
        if(cursor.getCount() > 0) return false;
        else return true;

    }
    //checking mail and pass
    public Boolean namepass(String name, String password, String phone, String birth)
    {
        SQLiteDatabase database=  this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from user where name=? and password=? and phone=? and birth=?",new String[] {name, password,phone,birth});
        if (cursor.getCount()> 0) return true;
        else return false;
    }
}
