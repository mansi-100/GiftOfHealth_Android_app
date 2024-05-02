package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.GiftOfHealth.Search_Doctor;

public class hospital_list extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        listView = findViewById(R.id.listView);

        String arr[] = {"Anand Surgical Hospital", "Balaji Hospital ( A Unit Of Shri Vhmrc Pvt Ltd)", "Nirmal Surgical Hospital", "Sola Civil Hospital", "Rugved Hospital", "Shaardaben Hospital", "Prathana Hospital", "Prasaad Hospital", "Gold River Hospital", "Aagman Hospital", "Aadya Eye Hospital", "Vikas eye Hospital", "Aakar Hospital", "Aalok Ortho Care", "Narayana Multispeciality Hospital", "Laxmi Hospital", "Shalby Hospital", "Civil Hospital", "Karnavati Super Speciality Hospital", "Suyoga Hospital", "Agrawal Hospital", "Anand Multispeciality Hospital", "Deep Intensive And Critical Care", "Zydus Hospital", "Devsya Multispeiclaity Hospital", "cadila hospital", "Haard Surgical Hospital", "Krishna Medical Hospital", "Matru Hospital", "Nikunj Surgical Hospital", "Pragati Hospital", "Pooja Hospital", "Sardar Hospital"};
//<!--add search option button-->
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                if (selectedItem == "Anand Surgical Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), map_aanad.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Balaji Hospital ( A Unit Of Shri Vhmrc Pvt Ltd)")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Balaji_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Nirmal Surgical Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Nirmal_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Sola Civil Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Sola_civil_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Rugved Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Rugved_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Shaardaben Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Shaardaben_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Prathana Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Prathana_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Prasaad Hospital")
                {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Prasaad_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Gold River Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Gold_River_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Aagman Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Aagman_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Aadya Eye Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Aadya_Eye_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Vikas eye Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Vikaas_Eye_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Aakar Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Aakar_Hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Aalok Ortho Care") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Aalok_ortho_care.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Narayana Multispeciality Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(),Narayana_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Laxmi Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Laxmi_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Shalby Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Shalby_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Civil Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), civil_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Karnavati Super Speciality Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Karanavati_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Suyoga Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), suyogya__hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Agrawal Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), agraval_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Anand Multispeciality Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), map_aanad.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Deep Intensive And Critical Care") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Deep_care.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Zydus Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), zydus_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Devsya Multispeiclaity Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), devsaya_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="cadila hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Kedila_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Haard Surgical Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Haard_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Krishna Medical Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), krishana_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Matru Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Matru_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem== "Nikunj Surgical Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), nikunj_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Pragati Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Pragati_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Pooja Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Pooja_hospital.class);
                    listView.getContext().startActivity(intent);
                }
                else if(selectedItem=="Sardar Hospital") {
                    Toast.makeText(hospital_list.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(listView.getContext(), Sardaar_hospital.class);
                    listView.getContext().startActivity(intent);
                }

            }
        });

    }
}