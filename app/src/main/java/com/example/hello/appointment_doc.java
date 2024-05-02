package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class appointment_doc extends AppCompatActivity {

    TextView textView3;
    Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_doc);
       // button7=findViewById(R.id.button7);
        textView3=findViewById(R.id.textView3);


        textView3.setText("Book the appointment!");
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String value = sharedPreferences.getString("value","");
        textView3.setText(value);

//        Intent intent = getIntent();
//        String message = intent.getStringExtra("message");
//        textView3.setText(message);


    }
    public void h3(View view)
    {
        Intent i=new Intent(this,payment.class);
        startActivity(i);
    }
}