package com.example.GiftOfHealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class doctor_dbhelper extends SQLiteOpenHelper {
    public doctor_dbhelper(Context context) {
        super(context, "gift_of_health.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Doctor_register (Doc_id INTEGER primary key AUTOINCREMENT NOT NULL ,REF_id INTEGER  NOT NULL,Name TEXT NOT NULL,Email TEXT NOT NULL,Contact_No TEXT NOT NULL,Address TEXT NOT NULL,Hospital_Address TEXT NOT NULL,Experience TEXT NOT NULL,Degree TEXT NOT NULL,Time TEXT NOT NULL,Password TEXT NOT NULL,Certificate TEXT NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean insert(Integer Ref, String name, String email, String phone, String add, String hospi, String expe, String deg, String time, String pass, String im)
    {
        SQLiteDatabase s=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("REF_id",Ref);
        contentValues.put("Name",name);
        contentValues.put("Email",email);
        contentValues.put("Contact_No",phone);
        contentValues.put("Address",add);
        contentValues.put(" Hospital_Address",hospi);
        contentValues.put("Experience",expe);
        contentValues.put("Degree",deg);
        contentValues.put("Time",time);
        contentValues.put("Password",pass);
        contentValues.put("Certificate",im);

        long r=s.insert("Doctor_Register",null,contentValues);
        if(r==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }

    }
}