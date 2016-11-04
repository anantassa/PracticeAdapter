package com.example.tassa.practiceadaptor;

/**
 * Created by Lenovo on 23/10/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import android.support.design.widget.FloatingActionButton;


import java.util.ArrayList;


public class FormAddStudent extends AppCompatActivity {

        private EditText idText;
        private EditText nameText;
        private EditText noregText;
        private EditText phoneText;
        private EditText mailText;
        private Student student;

      public static ArrayList<Student> studentArrayList = new ArrayList<>();
        static StudentList studentList;

    public static ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public static void setStudentArrayList(ArrayList<Student> studentArrayList) {
        FormAddStudent.studentArrayList = studentArrayList;
    }


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_student);

            idText = (EditText) findViewById(R.id.edit_id);
            nameText = (EditText) findViewById(R.id.edit_nama);
            noregText = (EditText) findViewById(R.id.edit_nim);
            phoneText = (EditText) findViewById(R.id.edit_phone);
            mailText = (EditText) findViewById(R.id.edit_email);

            idText.setEnabled(false);

            FloatingActionButton fabDone = (FloatingActionButton) findViewById(R.id.saveActionButton);
            FloatingActionButton fabCancel = (FloatingActionButton) findViewById(R.id.cancelActionButton);


            fabDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //release the krakens for saving new data
                    saveNewData();
                }
            });
            fabCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //close activity
                    finish();            }
            });

        }

        protected void saveNewData(){
            int id = getNextId();
            String noreg = noregText.getText().toString();
            String name = nameText.getText().toString();
            String phone = phoneText.getText().toString();
            String mail = mailText.getText().toString();
            student = new Student(id, noreg, name, mail, phone);
            getStudentArrayList().add(student);
            Toast.makeText(getApplicationContext(), "Added Successfull", Toast.LENGTH_SHORT).show();
            finish();

        }

        public int getNextId(){
            return getStudentArrayList().size();
        };
    }

