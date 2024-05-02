package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class payment extends AppCompatActivity {

    general_dbHelper dk;
    Button button9;
    EditText etp1,ph,etp2,no,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        button9=findViewById(R.id.button9);

        etp1=findViewById(R.id.etp1);
        ph=findViewById(R.id.ph);
        etp2=findViewById(R.id.etp2);
        no=findViewById(R.id.no);
        date=findViewById(R.id.date);

        dk=new general_dbHelper(this);


    }
    public void h2(View view)
    {
        String a,b,c,d,e;
        a=etp1.getText().toString();//card name
        b=ph.getText().toString();//card no
        c=etp2.getText().toString();//cvv
        d=no.getText().toString(); //amount
        e=date.getText().toString();//date

         int ee,f,g;
        ee=Integer.parseInt(b);
        f=Integer.parseInt(c);
        g=Integer.parseInt(d);

        boolean o=dk.pay(a,ee,f,g,e);
        if(o==false)
        {
            Toast.makeText(this, "Payment Error", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Thanks For Payment", Toast.LENGTH_SHORT).show();

        }
//
//        Log.e("name",a);
//        Log.e("no",b);
//        Log.e("cvv",c);
//        Log.e("am",d);
//        Log.e("da",e);

//


        Intent i=new Intent(this,Feedback.class);
        startActivity(i);
    }
}