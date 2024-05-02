package com.example.GiftOfHealth;


import static java.lang.reflect.Array.getInt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.admin_menu;

import java.sql.Connection;

public class MainActivity2 extends AppCompatActivity {


    private EditText f2,ep2;
    TextView textView;
    private Button button;

    general_dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       f2=findViewById(R.id.f2);
        ep2=findViewById(R.id.ep2);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        db=new general_dbHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f=f2.getText().toString();
                Log.d("mess",f);
                String g=ep2.getText().toString();
                Cursor res = db.getdata(f,g);
                if(res.getCount()==0){
                    Toast.makeText(MainActivity2.this, "Please Register YourSelf First", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity2.this,patient_registration.class);
                    startActivity(intent);
                    return;
                }

                Toast.makeText(MainActivity2.this, "Welcome To Gift Of Health", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity2.this,patient_details.class);
                startActivity(intent);

                SharedPreferences shared = getSharedPreferences("Patient_Login", MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("login_name",f);
                editor.apply();




            }
        });

    }
    public void openActivity(View view)
    {

        Intent intent=new Intent(this,patient_details.class);
        startActivity(intent);
    }

//    public void on(View view)
//    {
//        String f=f2.getText().toString();
//        Log.e("f",f);
//        Cursor c=db.getDataa(f);
//
//        SharedPreferences shared = getSharedPreferences("mainActivity2", MODE_PRIVATE);
//        SharedPreferences.Editor editor=shared.edit();
//        editor.apply();
//
//        if(c.getCount()==0) {
//            Toast.makeText(MainActivity2.this, "no data", Toast.LENGTH_SHORT).show();
//        }
//        StringBuffer buffer = new StringBuffer();
//        while(c.moveToNext()){
//            editor.putInt("id", c.getInt(0));
//            editor.putString("name",c.getString(1));
//            editor.putString("email",c.getString(2));
//            editor.putString("contact",c.getString(3));
//            editor.putString("addr",c.getString(4));
//            editor.putString("pass",c.getString(5));
//                    buffer.append("Your Feedback Name is :"+c.getString(1)+"\n");
//                    buffer.append("Your Feedback Date is  :"+c.getString(2)+"\n");
//                    buffer.append("Your Feedback Ratings is  :"+c.getString(3)+"\n");
//                    buffer.append("Your Feedback Message is :"+c.getString(4)+"\n\n");
//                    buffer.append("Your Feedback Message is :"+c.getString(5)+"\n\n");
//        }
//        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
//        builder.setCancelable(true);
//        builder.setTitle("Feedback");
//        builder.setMessage(buffer.toString());
//        builder.show();
//    }
//
//

}