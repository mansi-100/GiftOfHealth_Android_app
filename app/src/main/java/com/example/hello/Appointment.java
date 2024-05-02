package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class Appointment extends AppCompatActivity {

    Button button5, button6,button7;
//appointment jena naam ni hoy enu naam store kraayu 6 db ma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);


    }
    public void h(View view)
    {
        Intent intent=new Intent(this,new_Appointment.class);
        startActivity(intent);
    }
    public void h2(View view)
    {

        Intent intent=new Intent(this,Feedback.class);
        startActivity(intent);
    }
    public void h3(View view)
    {
        Intent intent=new Intent(this,appointment_doc.class);
        startActivity(intent);
    }

}