package com.example.GiftOfHealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.RectF;
import android.util.Log;

import com.example.hello.Feedback;
import com.example.hello.post_doc_login;

import java.util.ArrayList;

public class general_dbHelper extends SQLiteOpenHelper {

    public general_dbHelper(Context context) {
        super(context, "Gift_Of_Health.db", null, 1);
    }

    public general_dbHelper(post_doc_login context, ArrayList<String> date, ArrayList<String> time, ArrayList<String> hos, int[] programImages) {
        super(context, "Gift_Of_Health.db", null, 1);
    }

    public general_dbHelper(Context context, ArrayList<String> programNameList, ArrayList<String> programDescriptionList, int[] programImages, ArrayList<String> programEmailList, ArrayList<String> programHospitalList) {
        super(context, "Gift_Of_Health.db", null, 1);
    }
    @Override
    public void onConfigure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Register_Doctor (Doc_id INTEGER primary key AUTOINCREMENT NOT NULL ,REF_id INTEGER  NOT NULL,Name TEXT NOT NULL,Email TEXT NOT NULL,Contact_No TEXT NOT NULL,Address TEXT NOT NULL,Hospital_Address TEXT NOT NULL,Experience TEXT NOT NULL,Degree TEXT NOT NULL,Password TEXT NOT NULL,Category TEXT NOT NULL,Certificate TEXT NOT NULL)");

        db.execSQL("create table Register_patient (Pati_id INTEGER primary key AUTOINCREMENT not null,Name TEXT not null,Email TEXT not null,Contact_No String not null,Address TEXT not null,Password TEXT not null)");

        db.execSQL("create table Appointment (Appointment_id INTEGER primary key AUTOINCREMENT ,Appointment_Name TEXT not null,Appointment_Date TEXT not null,Appointment_Time TEXT not null,Hospital_Name TEXT not null)");

        db.execSQL("create table Feedback (Feedback_id INTEGER primary key AUTOINCREMENT,Feedback_Name TEXT NOT NULL,Feedback_Date TEXT NOT NULL,Feedback_Ratings TEXT NOT NULL,Feedback_Message TEXT NOT NULL)");

      //  db.execSQL("create table Payment (Payment_id INTEGER primary key AUTOINCREMENT,Card_Name TEXT NOT NULL,Card_No INTEGER CHECK(Card_No>100) ,CVV INTEGER CHECK(CVV>100) ,Amount INTEGER CHECK(Amount>0) ,Expiry_Date TEXT NOT NULL) ");

        db.execSQL("create table Admin (Admin_id INTEGER PRIMARY KEY AUTOINCREMENT,Admin_Email TEXT,Admin_Password TEXT)");

    }
    public boolean update_pati(String a,String b,String c,String d,String e)
    {
        Log.e("error code",e);
        SQLiteDatabase s=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", a);
        contentValues.put("Email",b);
        contentValues.put("Contact_No",c);
        contentValues.put("Address",d);
        long h=s.update("Register_patient",contentValues,"Email=?",new String[]{e});
        if (h==-1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean update_doc(String a,String b,String c,String d,String e,String f,String g)
    {
        Log.e("error code",e);
        SQLiteDatabase s=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", a);
        contentValues.put("Email",b);
        contentValues.put("Contact_No",c);
        contentValues.put("Address",d);
        contentValues.put("Hospital_Address",e);
        contentValues.put("Category",f);
        long h=s.update("Register_Doctor",contentValues,"Email=?",new String[]{g});
        if (h==-1) {
            return false;
        } else {
            return true;
        }
    }

//    public Cursor EditProf(String e) {
//        SQLiteDatabase s = this.getWritableDatabase();
//        Cursor c = s.rawQuery("select * from Register_patient where Email=?", new String[]{e});
//        return c;
//    }
    public Cursor get()
    {
        SQLiteDatabase s=this.getWritableDatabase();
        Cursor cursor=s.rawQuery("select * from Register_Doctor",null);
        return cursor;
    }
    public Cursor get2()
    {
        SQLiteDatabase s=this.getWritableDatabase();
        Cursor cursor=s.rawQuery("select * from Register_patient",null);
        return cursor;
    }
    public boolean pay(String n, Integer no, Integer CVV, Integer am, String Exp) {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Card_Name", n);
        contentValues.put("Card_No", no);
        contentValues.put("CVV", CVV);
        contentValues.put("Amount", am);
        contentValues.put("Expiry_Date", Exp);
        long so = s.insert("Payment", null, contentValues);
        if (so == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor payment_get() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Payment", null);

        // Cursor cursor=s.rawQuery("select Payment_id,Card_Name,Amount from Payment",null);
        return cursor;
    }

    public Cursor get(String n) {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Appointment where Appointment_Name=?", new String[]{n});
        return cursor;
    }

    public boolean feedback(String nm, String dat, String rat, String feed) {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Feedback_Name", nm);
        contentValues.put("Feedback_Date", dat);
        contentValues.put("Feedback_Ratings", rat);
        contentValues.put("Feedback_Message", feed);

        long r = s.insert("Feedback", null, contentValues);
        if (r == -1) {
            return false;
        } else {
            return true;
        }

        //db.execSQL("create table Feedback (Feedback_id INTEGER PRIMARY KEY AUTOINCREMENT,Feedback_Name TEXT NOT NULL,Feedback_Date TEXT NOT NULL,Feedback_Ratings TEXT NOT NULL,Feedback_Message TEXT NOT NULL)");
    }

    public Cursor viewFeedback() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor c = s.rawQuery("select * from Feedback", null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Register_patient");
        db.execSQL("drop table if exists Register_Doctor");
        db.execSQL("drop table if exists Appointment");
        db.execSQL("drop table if exists Feedback");
        db.execSQL("drop table if exists Payment");
    }

    public boolean insert(Integer Ref, String name, String email, String phone, String add, String hospi, String expe, String deg, String pass, String cat, String im) {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("REF_id", Ref);
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Contact_No", phone);
        contentValues.put("Address", add);
        contentValues.put(" Hospital_Address", hospi);
        contentValues.put("Experience", expe);
        contentValues.put("Degree", deg);
        contentValues.put("Password", pass);
        contentValues.put("Category", cat);
        contentValues.put("Certificate", im);

        long r = s.insert("Register_Doctor", null, contentValues);
        if (r == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getData(String Email, String Password) {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Register_Doctor where Email=? and password=?", new String[]{Email, Password});
        return cursor;
    }

    public Cursor viewData() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor", null);
        return cursor;
    }

    public Cursor doc_list1() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"General Practitioner"});
        return cursor;
    }

    public Cursor doc_list2() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Pediatrician"});
        return cursor;
    }

    public Cursor doc_list3() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Endocrinologist"});
        return cursor;
    }

    public Cursor doc_list4() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Rheumatologist"});
        return cursor;
    }

    public Cursor doc_list5() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Allergist/Immunologist"});
        return cursor;
    }

    public Cursor doc_list6() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"OB/GYN"});
        return cursor;
    }

    public Cursor doc_list7() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Anesthesiologist"});
        return cursor;
    }

    public Cursor doc_list8() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Podiatrist"});
        return cursor;
    }

    public Cursor doc_list9() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Neurologist"});
        return cursor;
    }

    public Cursor doc_list10() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Psychiatrist"});
        return cursor;
    }

    public Cursor doc_list11() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Nephrologist"});
        return cursor;
    }

    public Cursor doc_list12() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Pulmonologist"});
        return cursor;
    }

    public Cursor doc_list13() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Surgeon"});
        return cursor;
    }

    public Cursor doc_list14() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Dentist"});
        return cursor;
    }

    public Cursor doc_list15() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Emergency Physician"});
        return cursor;
    }

    public Cursor doc_list16() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Ophthalmologist"});
        return cursor;
    }

    public Cursor doc_list17() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Urologist"});
        return cursor;
    }

    public Cursor doc_list18() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Oncologist"});
        return cursor;
    }

    public Cursor doc_list19() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Radiologist"});
        return cursor;
    }

    public Cursor doc_list20() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Cardiologist"});
        return cursor;
    }

    public Cursor doc_list21() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select Name,Email,Contact_No,Hospital_Address from Register_Doctor where Category=?", new String[]{"Other Disease"});
        return cursor;
    }

    public boolean register(String name, String Email, String Phone, String add, String pass) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", Email);
        contentValues.put("Contact_No", Phone);
        contentValues.put("Address", add);
        contentValues.put("Password", pass);

        long r = sql.insert("Register_patient", null, contentValues);
        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert(String nm, String d, String t, String n) {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Appointment_Name", nm);
        contentValues.put("Appointment_Date", d);
        contentValues.put("Appointment_Time", t);
        contentValues.put("Hospital_Name", n);
        long r = s.insert("Appointment", null, contentValues);
        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata(String Email, String Password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Register_patient where Email=? and Password=?", new String[]{Email, Password});
        return cursor;
    }

    public Cursor getAppointmentData() {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("Select * from Appointment", null);
        return cursor;
    }

    public boolean admin(String e, String p) {
        SQLiteDatabase s = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Admin_Email", e);
        contentValues.put("Admin_Password", p);

        long k = s.insert("Admin", null, contentValues);
        if (k == -1) {
            return false;
        } else {
            return true;
        }


    }

    public Cursor add(String e, String p) {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Admin where Admin_Email=? and Admin_Password=?", new String[]{e, p});
        return cursor;
    }

    public Boolean doc_delete(String ss) {
        SQLiteDatabase s = this.getWritableDatabase();

            long k = s.delete("Register_Doctor", "Doc_id=?", new String[]{ss});
            if (k == -1) {
                return false;
            } else {
                return true;
            }
    }

    public Boolean patient_delete(String ss) {
        SQLiteDatabase s = this.getWritableDatabase();
        long k = s.delete("Register_patient", "Pati_id=?", new String[]{ss});
        if (k == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getDataa(String y) {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Register_patient where Email=?", new String[]{y});
        return cursor;
    }
    public Cursor getData(String y) {
        SQLiteDatabase s = this.getWritableDatabase();
        Cursor cursor = s.rawQuery("select * from Register_Doctor where Email=?", new String[]{y});
        return cursor;
    }
}
