package com.example.GiftOfHealth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hello.EditProfile_patient;
import com.example.hello.R;
import com.example.hello.ReportIssue;
import com.example.hello.hospital_list;

public class patient_details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    general_dbHelper d=new general_dbHelper(this);
    RadioButton r1, r4,r6;
    ImageButton imageButton4;
    Spinner spinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

     //   p2=findViewById(R.id.p2);
      //  button14=findViewById(R.id.button14);
        r1 = findViewById(R.id.r1);
        r4 = findViewById(R.id.r4);
        r6=findViewById(R.id.r6);
        spinner4 = findViewById(R.id.spinner4);

        String[] arr = {" ", "View Profile","Edit Profile", "Logout"};
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr);
        spinner4.setAdapter(a);

        spinner4.setOnItemSelectedListener(this);

        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(patient_details.this, ReportIssue.class);
                startActivity(i);
            }
        });
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
            SharedPreferences sharedPreferences = getSharedPreferences("Patient_Login", MODE_PRIVATE);
            String n = sharedPreferences.getString("login_name","");


           // Toast.makeText(this, "view", Toast.LENGTH_SHORT).show();
            Cursor res = d.getDataa(n);

            if (res.getCount() == 0) {
                Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
            } else {

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Patient id :" + res.getInt(0) + "\n");
                    buffer.append("Name  :" + res.getString(1) + "\n");
                    buffer.append("Email ID :" + res.getString(2) + "\n");
                    buffer.append("Contact No :" + res.getString(3) + "\n");
                    buffer.append("Address :" + res.getString(4) + "\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(patient_details.this);
                builder.setCancelable(true);
                builder.setTitle("View Profile");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        }
        else if(s=="Logout")
        {
            Toast.makeText(this, "Logout Successfully !", Toast.LENGTH_SHORT).show();
            Intent ii=new Intent(this,MainActivity.class);
            startActivity(ii);
        }

        else if(s=="Edit Profile")
        {
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            Intent ii=new Intent(this, EditProfile_patient.class);
            startActivity(ii);


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void b1(View view)
    {
        // Toast.makeText(this, "button1 clicked", Toast.LENGTH_SHORT).show();

        Intent i=new Intent(this,Search_Doctor.class);
        startActivity(i);

    }

    public void b2(View view) {
        Intent i = new Intent(this, hospital_list.class);
        startActivity(i);
    }

}


