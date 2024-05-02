package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;
import com.example.GiftOfHealth.doctor_registration;
import com.example.GiftOfHealth.patient_details;

public class doc_login extends AppCompatActivity {
    EditText f2,ep2;
    Button button;
    general_dbHelper d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);

        f2=findViewById(R.id.f2);
        ep2=findViewById(R.id.ep2);
        button=findViewById(R.id.button);

       d=new general_dbHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=f2.getText().toString();
                String s2=ep2.getText().toString();

                Log.d("data",s1+s2);
                Cursor c= d.getData(s1,s2);
                if(c.getCount()==0)
                {
                    Toast.makeText(doc_login.this, "Please Register YourSelf First", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(doc_login.this,doctor_registration.class);
                    startActivity(intent);
                    return;
                }
                Toast.makeText(doc_login.this, "welcome to Gift Of Health", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(doc_login.this,doc_menu.class);
                startActivity(intent);


                SharedPreferences shared = getSharedPreferences("Doctor_Login", MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("login_name",s1);
                editor.apply();

//                StringBuffer buffer = new StringBuffer();
//                while(c.moveToNext()){
//                    buffer.append("name :"+c.getString(0)+"\n");
//                    buffer.append("Email :"+c.getString(1)+"\n");
//                    buffer.append("Contact_No :"+c.getString(2)+"\n\n");
//                    buffer.append("Address :"+c.getString(3)+"\n\n");
//                    buffer.append("Password:"+c.getString(4)+"\n\n");
//                }
//                AlertDialog.Builder builder=new AlertDialog.Builder(doc_login.this);
//                builder.setCancelable(true);
//                builder.setTitle("user Entrries");
//                builder.setMessage(buffer.toString());
//                builder.show();

            }
        });

    }

}