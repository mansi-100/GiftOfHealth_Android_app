package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.GiftOfHealth.appointment_data;
import com.example.GiftOfHealth.general_dbHelper;

import java.util.ArrayList;

public class post_doc_login extends AppCompatActivity {

  RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutmanager;

    ArrayList<String> date;
    ArrayList<String> time;
    ArrayList<String> hos;

    int[] programImages = {R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor};

    general_dbHelper d = new general_dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_doc_login);
        recyclerView = findViewById(R.id.recyclerView);

        date=new ArrayList<>();
        time=new ArrayList<>();
        hos=new ArrayList<>();



        d=new general_dbHelper(this,date,time,hos,programImages);
        Cursor c = d.getAppointmentData();
        if (c.getCount() == 0) {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
           // Toast.makeText(this, "Data", Toast.LENGTH_SHORT).show();
            while (c.moveToNext()) {
                date.add(c.getString(1));
                time.add(c.getString(2));
                hos.add(c.getString(3));

            }
        }

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        // Create an instance of ProgramAdapter. Pass context and all the array elements to the constructor
       appointment_data h = new appointment_data(this,date,time,hos,programImages);
        // Finally, attach the adapter with the RecyclerView
        recyclerView.setAdapter(h);

//                StringBuffer buffer = new StringBuffer();
//                while(res.moveToNext()){
//                    buffer.append("Appointment_id :"+res.getInt(0)+"\n");
//                    buffer.append("Appointment_Date :"+res.getString(1)+"\n");
//                    buffer.append("Appointment_Time :"+res.getString(2)+"\n");
//                    buffer.append("Hospital_Name :"+res.getString(3)+"\n\n");
//                }


//                AlertDialog.Builder builder=new AlertDialog.Builder(post_doc_login.this);
//                builder.setCancelable(true);
//                builder.setTitle("user Entrries");
//                builder.setMessage(buffer.toString());
//                builder.show();
//
//                Toast.makeText(post_doc_login.this, "Data here ", Toast.LENGTH_SHORT).show();
    }
}