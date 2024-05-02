package com.example.GiftOfHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello.R;

public class Registration_options extends AppCompatActivity {
private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_options);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);


    }

    public void option2(View view)
    {
        Intent i=new Intent(this,doctor_registration.class);
        startActivity(i);
    }
    public void option3(View view)
    {
        Intent i=new Intent(this,patient_registration.class);
        startActivity(i);
    }
}