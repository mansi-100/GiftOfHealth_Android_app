package com.example.hello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;
import com.example.GiftOfHealth.patient_details;

public class EditProfile_patient extends AppCompatActivity {
    general_dbHelper d=new general_dbHelper(this);
    String o;
    EditText ep1,ep2,ep3,ep4;
    Button button18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_patient);

       ep1=findViewById(R.id.ep1);
        ep2=findViewById(R.id.ep2);
        ep3=findViewById(R.id.ep3);
        ep4=findViewById(R.id.ep4);

        button18=findViewById(R.id.button18);



        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e,f,g,h;
                e=ep1.getText().toString();
                f=ep2.getText().toString();
                g=ep3.getText().toString();
                h=ep4.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("Patient_Login", MODE_PRIVATE);
                String n = sharedPreferences.getString("login_name","");
                Log.e("name  jkjk",n);

                boolean b=d.update_pati(e,f,g,h,n);

                if(b==false)
                {
                    Toast.makeText(EditProfile_patient.this, "Sorry ! You Can't Update", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(EditProfile_patient.this, "Updated Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}