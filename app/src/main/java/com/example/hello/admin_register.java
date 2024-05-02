package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class admin_register extends AppCompatActivity {
    general_dbHelper s=new general_dbHelper(this);
    EditText et1,e2;
    Button button13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        et1=findViewById(R.id.et1);
        e2=findViewById(R.id.e2);

        button13=findViewById(R.id.button13);

    }
    public void k(View view)
    {

        String e,p;
        e=et1.getText().toString();
        p=e2.getText().toString();

        Log.e("em",e);
        Log.e("pass",p);

        boolean k=s.admin(e,p);
        if(k==false)
        {
            Toast.makeText(this, "Can't Register", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Dn", Toast.LENGTH_SHORT).show();
        }

    }
}