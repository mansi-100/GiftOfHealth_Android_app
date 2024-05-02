package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class admin_login extends AppCompatActivity {

    general_dbHelper a=new general_dbHelper(this);
    EditText f2,ep2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        f2=findViewById(R.id.f2);
        ep2=findViewById(R.id.ep2);

        button=findViewById(R.id.button);



    }
    public void hhh(View view)
    {

        String s1,s2;
        s1=f2.getText().toString();
        s2=ep2.getText().toString();

        Cursor c=a.add(s1,s2);
        if(c.getCount()==0)
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            while (c.moveToNext()) {
                Log.e("data", c.getString(1));
                Log.e("data", c.getString(2));
            }
            Intent intent=new Intent(this,admin_menu.class);
            startActivity(intent);
        }
//        Log.e("d",s1);
//        Log.e("d2",s2);




    }
}