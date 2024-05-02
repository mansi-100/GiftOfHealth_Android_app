package com.example.hello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.GiftOfHealth.doctor_registration;
import com.example.GiftOfHealth.general_dbHelper;
import com.example.GiftOfHealth.patient_registration;

public class managePatient extends AppCompatActivity {

    RadioButton r1,r2,r3;
    general_dbHelper d=new general_dbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);

    r1=findViewById(R.id.r1);
    r2=findViewById(R.id.r2);
    r3=findViewById(R.id.r3);

        r1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(managePatient.this, "Loading...", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(managePatient.this, patient_registration.class);
            startActivity(intent);
        }
    });
        r2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(managePatient.this, "Loading...", Toast.LENGTH_SHORT).show();
            Cursor c=d.get();
            StringBuffer buffer = new StringBuffer();
            while(c.moveToNext()){
                buffer.append("Patient ID is  :"+c.getInt(0)+"\n");
                buffer.append("Patient Name is :"+c.getInt(1)+"\n");
                buffer.append("Patient Email is  :"+c.getString(2)+"\n");
                buffer.append("Patient Contact No is  :"+c.getString(3)+"\n");
                buffer.append("Patient Address is  :"+c.getString(4)+"\n\n");

            }
            AlertDialog.Builder builder=new AlertDialog.Builder(managePatient.this);
            builder.setCancelable(true);
            builder.setTitle("Patient's List");
            builder.setMessage(buffer.toString());
            builder.show();

        }
    });
        r3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(managePatient.this, "Loading...", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(managePatient.this,delete_patient.class);
            startActivity(intent);
        }
    });

}
}