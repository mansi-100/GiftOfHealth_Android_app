package com.example.GiftOfHealth;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello.Appointment;
import com.example.hello.R;
import com.example.hello.chat;
import com.example.hello.doctor_list;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Create the adapter by extending RecyclerView.Adapter. This custom ViewHolder will give access to your views
public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {
    // Declare variables to store data from the constructor
    Button button3,button4;
    static View vil;
    Context context;
    ArrayList programNameList,programDescriptionList,programEmailList,programHospitalList;

    int[] images;

    // Create a static inner class and provide references to all the Views for each data item.
    // This is particularly useful for caching the Views within the item layout for fast access.
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // Declare member variables for all the Views in a row
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;
        TextView textView12,textView13;
        // Create a constructor that accepts the entire row and search the View hierarchy to find each subview
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vil=itemView;
            // Store the item subviews in member variables
            rowName = itemView.findViewById(R.id.textView11);
            rowDescription = itemView.findViewById(R.id.textView22);
            rowImage = itemView.findViewById(R.id.imageView);
            textView12=itemView.findViewById(R.id.textView12);
            textView13=itemView.findViewById(R.id.textView13);
        }
    }
    // Provide a suitable constructor
    public ProgramAdapter(Context context,ArrayList<String> programNameList,ArrayList<String> programDescriptionList, int[] images,ArrayList programEmailList,ArrayList programHospitalList){
        // Initialize the class scope variables with values received from constructor
        this.context = context;
        this.programNameList = programNameList;
        this.programDescriptionList = programDescriptionList;
        this.programEmailList=programEmailList;
        this.programHospitalList=programHospitalList;
        this.images = images;

    }

    // Create new views to be invoked by the layout manager
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a LayoutInflater object
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View view = inflater.inflate(R.layout.single_item, parent, false);
        // To attach OnClickListener
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rowName = v.findViewById(R.id.textView11);
               // Toast.makeText(context, "Clicked Item: " + rowName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(vil.getContext(), Appointment.class);
                vil.getContext().startActivity(i);
                Log.d("demo","onclick : for Appointment");
            }
        });
        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(vil.getContext(),chat.class);
                vil.getContext().startActivity(i);
                Log.d("demo","onclick:chat ");
            }
        });

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view to be invoked by the layout manager
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the contents of the View with that element
        holder.rowName.setText(String.valueOf(programNameList.get(position)));
        holder.rowDescription.setText(String.valueOf(programDescriptionList.get(position)));
        holder.rowImage.setImageResource(images[position]);
        holder.textView12.setText(String.valueOf(programEmailList.get(position)));
        holder.textView13.setText(String.valueOf(programHospitalList.get(position)));

    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return programNameList.size();
    }
}