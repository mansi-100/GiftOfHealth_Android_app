package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class delete_patient extends AppCompatActivity {
    general_dbHelper d=new general_dbHelper(this);
    Button button121;
    EditText ett11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_patient);

        ett11=findViewById(R.id.ett11);
        button121=findViewById(R.id.button121);

        button121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ett11.getText().toString();
                Boolean o =d.patient_delete(s);
                if(o==false)
                {
                    Toast.makeText(delete_patient.this, "No Data Avaliable", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(delete_patient.this, "Deleted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}