package com.example.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.GiftOfHealth.general_dbHelper;

public class admin_menu extends AppCompatActivity {

    RadioButton r1,r11,r4,r5;
    general_dbHelper d=new general_dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        r1=findViewById(R.id.r1);
        r11=findViewById(R.id.r11);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);



        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(admin_menu.this,manageDoc.class);
                startActivity(i);
            }
        });

        r11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(admin_menu.this,managePatient.class);
                startActivity(i);
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
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_menu.this);
                builder.setCancelable(true);
                builder.setTitle("Feedback");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
   r5.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           SharedPreferences sharedPreferences = getSharedPreferences("Report_issue", MODE_PRIVATE);
           String n = sharedPreferences.getString("Report_issue","");
           String i=sharedPreferences.getString("id","");
           String nm=sharedPreferences.getString("name","");

           StringBuffer buffer = new StringBuffer();
           buffer.append("id  : "+nm+"\n");
           buffer.append("name  :"+i+"\n");
           buffer.append("Complaint  : "+n+"\n");

           AlertDialog.Builder builder=new AlertDialog.Builder(admin_menu.this);
           builder.setCancelable(true);
           builder.setTitle("View Complaints ");
           builder.setMessage(buffer.toString());
           builder.show();

       }
   });

    }
}