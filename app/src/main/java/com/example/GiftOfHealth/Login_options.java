package com.example.GiftOfHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello.R;
import com.example.hello.admin_login;
import com.example.hello.admin_register;
import com.example.hello.doc_login;


public class Login_options extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);

    }
    public void option(View view)
    {
        Intent i=new Intent(this,MainActivity2.class);
        startActivity(i);

    }
    public void option2(View view)
    {
        Intent i=new Intent(this, doc_login.class);
        startActivity(i);

    }
    public void option3(View view)
    {
        Intent i=new Intent(this, admin_login.class);
        startActivity(i);


    }
}