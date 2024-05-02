package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.GiftOfHealth.general_dbHelper;

public class Feedback extends AppCompatActivity {

    EditText etd2,et2,etd;
    RatingBar ratingBar;
    Button button8;
    general_dbHelper dk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        etd2=findViewById(R.id.etd2);
        et2=findViewById(R.id.et2);
        etd=findViewById(R.id.etd);
        button8=findViewById(R.id.button8);
        ratingBar=findViewById(R.id.ratingBar);
        dk=new general_dbHelper(this);

    }
    public void hm(View vi)
    {
        String r="rating bar is "+ratingBar.getRating();
        String r2=String.valueOf(ratingBar.getRating());
       // Toast.makeText(this, r, Toast.LENGTH_SHORT).show();

        String nm=etd2.getText().toString();
        String d=etd.getText().toString();
        String f=et2.getText().toString();

        Log.e("name",nm);
        Log.e("date",d);
        Log.e("rating",r2);
        Log.e("feed",f);


        boolean o=dk.feedback(nm,d,r2,f);
        if(o==false)
        {
            Toast.makeText(this, "Feedback ERROR", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Thanks For Your Feedback and Using our App ", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,thank.class);
            startActivity(intent);

        }




    }
}
