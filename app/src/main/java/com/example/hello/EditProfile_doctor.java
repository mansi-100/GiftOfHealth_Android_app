package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class EditProfile_doctor extends AppCompatActivity {

    general_dbHelper d=new general_dbHelper(this);
    String o;
    EditText ep1,ep2,ep3,ep4,ep5,ep6;
    Button button18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_doctor);

        ep1=findViewById(R.id.ep1);
        ep2=findViewById(R.id.ep2);
        ep3=findViewById(R.id.ep3);
        ep4=findViewById(R.id.ep4);
        ep5=findViewById(R.id.ep5);
        ep6=findViewById(R.id.ep6);
        //String[] items = {"Choose Your Category","General Practitioner", "Pediatrician", "Endocrinologist", "Rheumatologist", "Allergist/Immunologist", "OB/GYN", "Anesthesiologist", "Podiatrist", "Neurologist", "Psychiatrist", "Nephrologist", "Pulmonologist", "Surgeon", "Dentist", "Emergency Physician", "Ophthalmologist", "Urologist", "Oncologist", "Radiologist", "Cardiologist", "Other Disease"};

        button18=findViewById(R.id.button18);



        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e,f,g,h,i,j;
                e=ep1.getText().toString();
                f=ep2.getText().toString();
                g=ep3.getText().toString();
                h=ep4.getText().toString();
                i=ep5.getText().toString();
                j=ep6.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("Doctor_Login", MODE_PRIVATE);
                String n = sharedPreferences.getString("login_name","");
                Log.e("name  jkjk",n);

                boolean b=d.update_doc(e,f,g,h,i,j,n);

                if(b==false)
                {
                    Toast.makeText(EditProfile_doctor.this, "Sorry ! You Can't Update", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(EditProfile_doctor.this, "Updated Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
