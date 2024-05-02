package com.example.GiftOfHealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class patient_dbHelper  extends SQLiteOpenHelper {

    public patient_dbHelper(Context context) {
            super(context, "gift_of_health.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Register (id INTEGER primary key AUTOINCREMENT not null,Name TEXT not null ,Email TEXT not null,Contact_No TEXT not null,Address TEXT not null,Password TEXT not null)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
          //  db.execSQL("drop table if exists Register");
        }

        public boolean register(String name,String Email,String Phone,String add,String pass)
        {
            SQLiteDatabase sql=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("Name",name);
            contentValues.put("Email",Email);
            contentValues.put("Contact_No",Phone);
            contentValues.put("Address",add);
            contentValues.put("Password",pass);
            long r=sql.insert("Register",null,contentValues);
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
