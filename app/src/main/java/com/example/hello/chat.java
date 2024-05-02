package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class chat extends AppCompatActivity {

    RadioButton radioButton,radioButton3,radioButton4,radioButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        
        radioButton=findViewById(R.id.radioButton);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);
        radioButton5=findViewById(R.id.radioButton5);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chat.this, "You can book your Appointment Between 10AM to 8 PM Except Break Time ", Toast.LENGTH_SHORT).show();
            }
        });


        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chat.this, "You can Pay Directly To the Hospital", Toast.LENGTH_SHORT).show();
            }
        });
        
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chat.this, "For Other Query Book an Appointment with the Doctor ", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chat.this, "2PM to 4PM is break time, you can book your appointment in other available time slots.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}