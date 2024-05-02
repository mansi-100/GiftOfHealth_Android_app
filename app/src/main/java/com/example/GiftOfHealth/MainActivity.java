package com.example.GiftOfHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello.Feedback;
import com.example.hello.R;

public class MainActivity extends AppCompatActivity {
    public Button Login;
    public Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login=findViewById(R.id.Login);
        Register=findViewById(R.id.Register);

    }
    public void openActivity(View v)
    {
//        Intent intent=new Intent(this, Feedback.class);
//        startActivity(intent);
        Intent intent=new Intent(this,Login_options.class);
        startActivity(intent);
    }

    public void options(View v)
    {
        Intent intent=new Intent(this,Registration_options.class);
        startActivity(intent);
    }
    //onclick lsitener try kru.3

}