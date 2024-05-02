package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.GiftOfHealth.general_dbHelper;

public class delete_doc extends AppCompatActivity {

    general_dbHelper d=new general_dbHelper(this);
    Button button12;
    EditText ett1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_doc);

        ett1=findViewById(R.id.ett1);
        button12=findViewById(R.id.button12);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ett1.getText().toString();
                int s2=Integer.parseInt(s);
              Boolean o =d.doc_delete(s);
               if(o==false)
               {
                   Toast.makeText(delete_doc.this, "No Data Avaliable", Toast.LENGTH_SHORT).show();
               }
               Toast.makeText(delete_doc.this, "Deleted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}