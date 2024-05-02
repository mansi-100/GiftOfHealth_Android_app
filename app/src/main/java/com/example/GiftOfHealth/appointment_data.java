package com.example.GiftOfHealth;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello.Appointment;
import com.example.hello.R;
import com.example.hello.appointment_doc;
import com.example.hello.chat;
import com.example.hello.new_Appointment;

import java.util.ArrayList;

public class appointment_data extends RecyclerView.Adapter<appointment_data.ViewHolder>  {
        // Declare variables to store data from the constructor

        static View vil;
        Context context;
        ArrayList date,time,hos;

        int[] images;

//    @Override
//    public void onClick(View view) {
//
////            switch (view.getId())
////            {
////
////                case R.id.button33:
////                    Toast.makeText(context, "Appointment declined", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(vil.getContext(),appointment_doc.class);
////                    intent.putExtra("message", "Appointment status : Declined");
////                    vil.getContext().startActivity(intent);
////
////                    break;
////
////                case R.id.button44:
////                    Toast.makeText(context, "Appointment accepted", Toast.LENGTH_SHORT).show();
////                    Intent intentm = new Intent(vil.getContext(),appointment_doc.class);
////                    intentm.putExtra("message", "Appointment status : Accepted");
////                    vil.getContext().startActivity(intentm);
////                    break;
////
////
////            }
//
//
//    }

    // Create a static inner class and provide references to all the Views for each data item.
        // This is particularly useful for caching the Views within the item layout for fast access.
        public static class ViewHolder extends RecyclerView.ViewHolder{
            // Declare member variables for all the Views in a row
            Button button33,button44;
            TextView rowDescription;
            ImageView rowImage;
            TextView textView12,textView13,textView6;
            // Create a constructor that accepts the entire row and search the View hierarchy to find each subview
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                vil=itemView;
                // Store the item subviews in member variables
                rowDescription = itemView.findViewById(R.id.textView22);
                rowImage = itemView.findViewById(R.id.imageView);
                textView12=itemView.findViewById(R.id.textView12);
                textView13=itemView.findViewById(R.id.textView13);
                button33=itemView.findViewById(R.id.button33);
                button44=itemView.findViewById(R.id.button44);
                textView6=itemView.findViewById(R.id.textView6);

            }
        }
        // Provide a suitable constructor
        public appointment_data(Context context, ArrayList<String> date, ArrayList<String> time, ArrayList hos, int[] images){
            // Initialize the class scope variables with values received from constructor
            this.context = context;
            this.date = date;
            this.time=time;
            this.hos=hos;
            this.images = images;

        }

        // Create new views to be invoked by the layout manager
        @NonNull
        @Override

        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Create a LayoutInflater object
            LayoutInflater inflater = LayoutInflater.from(context);
            // Inflate the custom layout
            View view = inflater.inflate(R.layout.appointment_layout, parent, false);
            // To attach OnClickListener


            String n=null;
            view.findViewById(R.id.button33).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button button33=view.findViewById(R.id.button33);
//                    Button button44=view.findViewById(R.id.button44);
//                    TextView textView6=view.findViewById(R.id.textView6);
                    Toast.makeText(vil.getContext(), "Decline", Toast.LENGTH_SHORT).show();

                    
                    String value = "Appointment Rejected ! " ;
                    SharedPreferences sharedPref = context.getSharedPreferences("myKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("value", value);
                    editor.apply();
//                    Intent intent = new Intent(vil.getContext(), appointment_doc.class);
//                   vil.getContext().startActivity(intent);

//                    Intent intent = new Intent(vil.getContext(), appointment_doc.class);
//                    vil.getContext().startActivity(intent);

//                    Intent intent = new Intent(vil.getContext(),appointment_doc.class);
//                    intent.putExtra("message", "Appointment status : Rejected");
//                    vil.getContext().startActivity(intent);

                }
            });
//
            view.findViewById(R.id.button44).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Button button33=view.findViewById(R.id.button33);
                    Button button44=view.findViewById(R.id.button44);

                    Toast.makeText(vil.getContext(), "Accepted", Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(vil.getContext(),appointment_doc.class);
//                    intent.putExtra("message", "Appointment status : Accepted");
//                    vil.getContext().startActivity(intent);
//
                    String value = "Appointment Accepted ! " ;
                    SharedPreferences sharedPref = context.getSharedPreferences("myKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("value", value);
                    editor.apply();
                    Intent intent = new Intent(vil.getContext(), appointment_doc.class);
                    vil.getContext().startActivity(intent);

                   // button33.setText("Accepted");

                }
            });
//            Button b=view.findViewById(R.id.button33);
//            Button b2=view.findViewById(R.id.button44);
//            b.setOnClickListener(this);
//            b2.setOnClickListener(this);

            view.findViewById(R.id.textView6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView6=view.findViewById(R.id.textView6);
                   // Button button33=view.findViewById(R.id.button33);
                   // Button button44=view.findViewById(R.id.button44);
                    textView6.setText("Completed");


                }
            });


            // Return a new holder instance
           ViewHolder viewHolder = new ViewHolder(view);
           return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowDescription.setText(String.valueOf(date.get(position)));
        holder.textView12.setText(String.valueOf(time.get(position)));
        holder.textView13.setText(String.valueOf(hos.get(position)));
        holder.rowImage.setImageResource(images[position]);


    }

        // Return the size of your dataset
        @Override
        public int getItemCount() {
            return hos.size();
        }
    }
