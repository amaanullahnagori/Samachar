// <======Database class=======>
 package com.example.samachar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public  final class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context, "Login", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userdata(name text,username text primary key ,password text)");
    }
                                                
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table  if exists userdata ");
    }

        public boolean insert(String name, String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("userdata", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userdata where username =?",
                new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userdata where username=? and password =?",
                new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkPassword(String username ,String password)
    {
        SQLiteDatabase db=getWritableDatabase();
     Cursor c=db.rawQuery("select password from userdata where username =?",new String []{username});
     String correctpasswordforUser=c.toString();
     if (correctpasswordforUser.equals(password))
     {
         return true ;
     }
   else {
       return false;
     }
    }
}


