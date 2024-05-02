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

public class new_Appointment extends AppCompatActivity {

    EditText date,ep22;
    Button button2;
    EditText textView4,textView5;
    general_dbHelper d=new  general_dbHelper(this);
    Spinner spinner2,spinner3;
    String arr[] = {"Choose the Hospital","Anand Surgical Hospital", "Balaji Hospital ( A Unit Of Shri Vhmrc Pvt Ltd)", "Nirmal Surgical Hospital", "Sola Civil Hospital", "Rugved Hospital", "Shaardaben Hospital", "Prathana Hospital", "Prasaad Hospital", "Gold River Hospital", "Aagman Hospital", "Aadya Eye Hospital", "Vikas eye Hospital", "Aakar Hospital", "Aalok Ortho Care", "Narayana Multispeciality Hospital", "Laxmi Hospital", "Shalby Hospital", "Civil Hospital", "Karnavati Super Speciality Hospital", "Suyoga Hospital", "Agrawal Hospital", "Anand Multispeciality Hospital", "Deep Intensive And Critical Care", "Zydus Hospital", "Devsya Multispeiclaity Hospital", "cadila hospital", "Haard Surgical Hospital", "Krishna Medical Hospital", "Matru Hospital", "Nikunj Surgical Hospital", "Pragati Hospital", "Pooja Hospital", "Sardar Hospital"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);
        date=findViewById(R.id.date);
        button2=findViewById(R.id.button2);
        spinner2=findViewById(R.id.spinner2);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        spinner3=findViewById(R.id.spinner3);
        ep22=findViewById(R.id.ep22);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner2.setAdapter(adapter);


        String arr2[]={"Choose the Time ","10AM-11AM","11AM-12PM","12PM-01PM","01PM-02PM","04PM-05PM","05PM-06PM","07PM-08PM"};
        ArrayAdapter<String> time=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr2);
        spinner3.setAdapter(time);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(new_Appointment.this, "dn", Toast.LENGTH_SHORT).show();

            }
        });
//        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?>  adapterView, View view, int i, long l) {
//                String selectedItem = adapterView.getItemAtPosition(i).toString();
//
//                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.RED); /* if you want your item to be white */
//                Log.e("error",selectedItem);
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//
//        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s=date.getText().toString();
                String s2=textView5.getText().toString(); //time
                String s3=textView4.getText().toString(); //hospi
                String s0=ep22.getText().toString();

                Log.e("values",s);
                Log.e("values2",s2);
                Log.e("values3",s0);
                Log.e("value4",s3);

                boolean h=d.insert(s0,s,s2,s3);

                if (h==false)
                {
                    Toast.makeText(new_Appointment.this, "Failed To Take Appointment", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(new_Appointment.this, appointment_doc.class);
//                    intent.putExtra("message", "Appointment status : Rejected");
//                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(new_Appointment.this, "Your Appointment Request Has Been Sent !", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(new_Appointment.this, appointment_doc.class);
//                    intent.putExtra("message", "Appointment status : Accepted");
//                    startActivity(intent);


                }
//
            }
        });

    }
}