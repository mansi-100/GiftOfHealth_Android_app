package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.GiftOfHealth.ProgramAdapter;
import com.example.GiftOfHealth.general_dbHelper;

import java.util.ArrayList;

public class doc_type6 extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    general_dbHelper d;
    ArrayList<String> programNameList,programDescriptionList, programEmailList,programHospitalList;

    int[] programImages = {R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor,
            R.drawable.doctor, R.drawable.doctor, R.drawable.doctor};

    //    public ProgramAdapter(Context context, ArrayList programNameList, ArrayList programDescriptionList, int[] images,ArrayList programEmailList,ArrayList programHospitalList){
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        programNameList = new ArrayList<>();
        programDescriptionList = new ArrayList<>();
        programEmailList = new ArrayList<>();
        programHospitalList = new ArrayList<>();

        d=new general_dbHelper(this,programNameList,programDescriptionList,programImages,programEmailList,programHospitalList);
        Cursor c = d.doc_list6();
        if (c.getCount() == 0) {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        } else {
         //   Toast.makeText(this, "Data", Toast.LENGTH_SHORT).show();
            while (c.moveToNext()) {
                programNameList.add(c.getString(0));
                programDescriptionList.add(c.getString(1)); //contact
                programEmailList.add(c.getString(2));
                programHospitalList.add(c.getString(3));

            }


//
//            StringBuffer buffer = new StringBuffer();
//            while (c.moveToNext()) {
//                buffer.append("Name :" + c.getString(0) + "\n");
//                buffer.append("Email:" + c.getString(1) + "\n");
//                buffer.append("Contact_No :" + c.getString(2) + "\n");
//                buffer.append("Hospital_Address :" + c.getString(3) + "\n\n");
//
//            }
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(doctor_list.this);
//            builder.setCancelable(true);
//            builder.setTitle("user Entrries");
//            builder.setMessage(buffer.toString());
//            builder.show();
        }

        setContentView(R.layout.activity_doctor_list);
        // Obtain a handle for the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        // You may use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        // Create an instance of ProgramAdapter. Pass context and all the array elements to the constructor
        programAdapter = new ProgramAdapter(this, programNameList, programDescriptionList, programImages, programEmailList, programHospitalList);
        // Finally, attach the adapter with the RecyclerView
        recyclerView.setAdapter(programAdapter);


    }
}