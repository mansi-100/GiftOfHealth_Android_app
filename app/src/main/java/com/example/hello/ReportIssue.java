package com.example.hello;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportIssue extends AppCompatActivity {

    EditText p1,p,p121;
    Button button14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issue);

        p1=findViewById(R.id.p1);
        p=findViewById(R.id.p);
        p121=findViewById(R.id.p121);

        button14=findViewById(R.id.button14);

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("write",p1.getText().toString());
                String s=p1.getText().toString();
                String i=p121.getText().toString();
                String n=p.getText().toString();

                SharedPreferences shared = getSharedPreferences("Report_issue", MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("Report_issue",s);
                editor.putString("id",i);
                editor.putString("name",n);
                editor.apply();



                Toast.makeText(ReportIssue.this, "Report sent Successfully ! ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}