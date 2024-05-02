package com.example.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.GiftOfHealth.MainActivity;
import com.example.GiftOfHealth.general_dbHelper;

public class doc_menu extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RadioButton r1,r4,r6;
    Spinner spinner4;

    general_dbHelper d=new general_dbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_menu);

        r1=findViewById(R.id.r1);
        r4=findViewById(R.id.r4);
        r6=findViewById(R.id.r6);
        spinner4=findViewById(R.id.spinner4);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(doc_menu.this,post_doc_login.class);
                startActivity(intent);
            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=d.viewFeedback();
                StringBuffer buffer = new StringBuffer();
                while(c.moveToNext()){
                    buffer.append("Your Feedback id is  :"+c.getString(0)+"\n");
                    buffer.append("Your Feedback Name is :"+c.getString(1)+"\n");
                    buffer.append("Your Feedback Date is  :"+c.getString(2)+"\n");
                    buffer.append("Your Feedback Ratings is  :"+c.getString(3)+"\n");
                    buffer.append("Your Feedback Message is :"+c.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(doc_menu.this);
                builder.setCancelable(true);
                builder.setTitle("Feedback List");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(doc_menu.this, ReportIssue.class);
                startActivity(i);
            }
        });
//        r5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor c=d.payment_get();
//                StringBuffer buffer = new StringBuffer();
//                while(c.moveToNext()){
//                    buffer.append("Payment id is  :"+c.getInt(0)+"\n");
//                    buffer.append("Payment Name is :"+c.getString(1)+"\n");
//                    buffer.append("Payment Amount is  :"+c.getInt(4)+"\n\n");
//
////                    buffer.append("Your  card no :"+c.getInt(2)+"\n");
////                    buffer.append("Your  card cv :"+c.getInt(3)+"\n");
//                   // buffer.append("Your Expiry date is  :"+c.getString(5)+"\n\n");
//
//                }
//                AlertDialog.Builder builder=new AlertDialog.Builder(doc_menu.this);
//                builder.setCancelable(true);
//                builder.setTitle("Payment Received");
//                builder.setMessage(buffer.toString());
//                builder.show();
//            }
//        });

        String[] arr = {" ", "View Profile","Edit Profile", "Logout"};
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr);
        spinner4.setAdapter(a);

        spinner4.setOnItemSelectedListener(this);

      /*  imageButton4=findViewById(R.id.imageButton4);


        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(patient_details.this, view_profile.class);
                startActivity(i);
            }
        });*/


    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getItemAtPosition(i);
        Object s=adapterView.getSelectedItem();
        Log.e("val", String.valueOf(s));
        Log.e("d", String.valueOf(i));

        if(s=="View Profile") {
            SharedPreferences sharedPreferences = getSharedPreferences("Doctor_Login", MODE_PRIVATE);
            String n = sharedPreferences.getString("login_name","");


            // Toast.makeText(this, "view", Toast.LENGTH_SHORT).show();
            Cursor res = d.getData(n);

            if (res.getCount() == 0) {
                Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
            } else {

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Doctor id :" + res.getInt(0) + "\n");
                    buffer.append("REF id :" + res.getInt(1) + "\n");
                    buffer.append("Name  :" + res.getString(2) + "\n");
                    buffer.append("Email ID :" + res.getString(3) + "\n");
                    buffer.append("Contact No :" + res.getString(4) + "\n");
                    buffer.append("Address :" + res.getString(5) + "\n");
                    buffer.append("Hospital Address :" + res.getString(6) + "\n");
                    buffer.append("Experience :" + res.getString(7) + "\n");
                    buffer.append("Degree :" + res.getString(8) + "\n");
                    buffer.append("Category :" + res.getString(10) + "\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(doc_menu.this);
                builder.setCancelable(true);
                builder.setTitle("View Profile");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        }
        else if(s=="Logout")
        {
            Toast.makeText(this, "Logout Successfully !", Toast.LENGTH_SHORT).show();
            Intent ii=new Intent(this, MainActivity.class);
            startActivity(ii);
        }
        else if(s=="Edit Profile")
        {
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            Intent ii=new Intent(this, EditProfile_doctor.class);
            startActivity(ii);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}

