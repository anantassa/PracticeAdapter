package com.example.tassa.practiceadaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23/10/2016.
 */

public class Adapter extends ArrayAdapter<Student> {
    public Adapter(Context context, ArrayList<Student> studentArrayList) {
        super(context, 0, studentArrayList);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Student student = getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.student_list,parent,false);
        }
        // Lookup view for data population

        TextView idView = (TextView) convertView.findViewById(R.id.student_id);
        TextView noregView = (TextView) convertView.findViewById(R.id.student_noreg);
        TextView nameView = (TextView) convertView.findViewById(R.id.student_name);
        TextView mailView = (TextView) convertView.findViewById(R.id.student_email);
        TextView phoneView = (TextView) convertView.findViewById(R.id.student_phone);

        //set content
        idView.setText(student.getId() + "");
        noregView.setText(student.getNoreg());
        nameView.setText(student.getName());
        mailView.setText(student.getMail());
        phoneView.setText(student.getPhone());
        return convertView;
    }



}

