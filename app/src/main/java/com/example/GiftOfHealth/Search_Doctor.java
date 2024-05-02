package com.example.GiftOfHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.doc_type1;
import com.example.hello.doc_type10;
import com.example.hello.doc_type11;
import com.example.hello.doc_type12;
import com.example.hello.doc_type13;
import com.example.hello.doc_type14;
import com.example.hello.doc_type15;
import com.example.hello.doc_type16;
import com.example.hello.doc_type17;
import com.example.hello.doc_type18;
import com.example.hello.doc_type19;
import com.example.hello.doc_type2;
import com.example.hello.doc_type20;
import com.example.hello.doc_type21;
import com.example.hello.doc_type3;
import com.example.hello.doc_type4;
import com.example.hello.doc_type5;
import com.example.hello.doc_type6;
import com.example.hello.doc_type7;
import com.example.hello.doc_type8;
import com.example.hello.doc_type9;
import com.example.hello.doctor_list;

public class Search_Doctor extends AppCompatActivity {

    ListView listView;
    // textView;
    String arr[] = {"General Practitioner", "Pediatrician", "Endocrinologist", "Rheumatologist", "Allergist/Immunologist", "OB/GYN", "Anesthesiologist", "Podiatrist", "Neurologist", "Psychiatrist", "Nephrologist", "Pulmonologist", "Surgeon", "Dentist", "Emergency Physician", "Ophthalmologist", "Urologist", "Oncologist", "Radiologist", "Cardiologist", "Other Disease"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctor);
        listView = findViewById(R.id.listView);
      //  textView = findViewById(R.id.textView);

        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(a);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = (String) adapterView.getItemAtPosition(i);
              //  textView.setText(selectedItem);
                //  Intent a;
                if (selectedItem == "General Practitioner") {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type1.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Pediatrician")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type2.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Endocrinologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type3.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Rheumatologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type4.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Allergist/Immunologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type5.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "OB/GYN")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type6.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Anesthesiologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type7.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Podiatrist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type8.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Neurologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type9.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Psychiatrist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type10.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Nephrologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type11.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Pulmonologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type12.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Surgeon")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type13.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Dentist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type14.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Emergency Physician")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type15.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Ophthalmologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type16.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Urologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type17.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Oncologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type18.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Radiologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type19.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Cardiologist")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type20.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Other Disease")
                {
                    Toast.makeText(Search_Doctor.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), doc_type21.class);
                    listView.getContext().startActivity(intent);
                }


            }
        });
    }
}