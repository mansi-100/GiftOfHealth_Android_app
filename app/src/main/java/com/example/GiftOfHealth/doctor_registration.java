package com.example.GiftOfHealth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.doc_login;
import com.example.hello.doc_menu;
import com.example.hello.post_doc_login;


public class doctor_registration extends AppCompatActivity {

    private Button bt2;
    EditText textView4;
    Spinner spinner;
    private ImageView iv;
    private Button button;
    int code=1;
    general_dbHelper d;
    private EditText f1,f2,f3,f4,f5,f6,f7,f9,editTextTextPersonName;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);

        spinner=findViewById(R.id.spinner);
        textView4=findViewById(R.id.textView4);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        f6=findViewById(R.id.f6);
        f7=findViewById(R.id.f7);
       // f8=findViewById(R.id.f8);
        f9=findViewById(R.id.f9);
        bt2=findViewById(R.id.bt2);
        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        iv=findViewById(R.id.iv);
//https://youtu.be/7v9afVcQCxw link
        button=findViewById(R.id.button);

        String[] items = {"Choose Your Category","General Practitioner", "Pediatrician", "Endocrinologist", "Rheumatologist", "Allergist/Immunologist", "OB/GYN", "Anesthesiologist", "Podiatrist", "Neurologist", "Psychiatrist", "Nephrologist", "Pulmonologist", "Surgeon", "Dentist", "Emergency Physician", "Ophthalmologist", "Urologist", "Oncologist", "Radiologist", "Cardiologist", "Other Disease"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(adapter);

      //  String selected = String.valueOf(spinner.getAdapter().getItem(position));
//
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                ((TextView) parent.getChildAt(0)).setTextColor(Color.RED); /* if you want your item to be white */


//
//
             //   Log.e("selected position",""+itemposition);
              Log.e("selected Text",selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        d=new general_dbHelper(this);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                //i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"title"),code);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            Uri uri=data.getData();
            iv.setImageURI(uri);
        }
    }

    public void op(View view)
    {
        String cat=textView4.getText().toString();
        int sw=Integer.parseInt(f1.getText().toString());
        String nm=f2.getText().toString();
        String em=f3.getText().toString();
        String ph=f4.getText().toString();
        String add=f5.getText().toString();
        String hos=editTextTextPersonName.getText().toString();
        String ex=f6.getText().toString();
        String deg=f7.getText().toString();
        //String tim=f8.getText().toString();
        String pas=f9.getText().toString();
        String im= iv.getImageMatrix().toString();



        boolean b=d.insert(sw,nm,em,ph,add,hos,ex,deg,pas,cat,im);
                if(b==false)
                {
                    Toast.makeText(this, "Sorry You Can't Register", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(doctor_registration.this, "Thanks For Register", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(doctor_registration.this, doc_login.class);
                    startActivity(i);

                }




    }

}