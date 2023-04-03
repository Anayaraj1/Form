package com.example.myform;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper
{


    public MyDatabase(@Nullable Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table student (id integer primary key autoincrement ,username varchar(20),email varchar(20),password varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    long insertData(String username,String email,String Password)
    {
      SQLiteDatabase sd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",Password);
        long id =sd.insert("student",null,cv);
        return id;
    }
}
