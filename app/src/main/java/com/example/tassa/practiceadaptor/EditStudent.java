package com.example.tassa.practiceadaptor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lenovo on 03/11/2016.
 */

public class EditStudent  extends AppCompatActivity implements Serializable {
        private EditText editNo, editNoreg, editNama, editEmail, editTelp;
        private FloatingActionButton btnEdit, btnCancel;
        private boolean isEdit = false;
        ArrayList<Student> students;
        private int position;//save posisi object

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_student);
            students = StudentActivity.students;

            editNo = (EditText)findViewById(R.id.edit_id);
            editNoreg = (EditText)findViewById(R.id.edit_nim);
            editNama = (EditText)findViewById(R.id.edit_nama);
            editEmail = (EditText)findViewById(R.id.edit_email);
            editTelp = (EditText)findViewById(R.id.edit_phone);

            Intent i = getIntent();
            if(i.getBooleanExtra("isEdit", true)){
                isEdit = true;
                Student student = (Student)i.getSerializableExtra("student");
                editNo.setText(String.valueOf(student.getId()));
                editNoreg.setText(student.getNoreg());
                editNama.setText(student.getName());
                editEmail.setText(student.getMail());
                editTelp.setText(student.getPhone());
                position = i.getIntExtra("position", 0);
            }else {
                editNo.setText(String.valueOf(students.size()));
            }

            btnCancel = (FloatingActionButton)findViewById(R.id.cancelActionButton);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            btnEdit = (FloatingActionButton)findViewById(R.id.addFloatingActionButton);
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    simpan();
                }
            });
        }

        private void simpan() {
            if (isEdit){
                Student tmp = new Student(Integer.parseInt(
                        editNo.getText().toString()),
                        editNoreg.getText().toString(),
                        editNama.getText().toString(),
                        editEmail.getText().toString(),
                        editTelp.getText().toString());
                students.set(position, tmp);
                finish();
            }else {
                Student tmp = new Student(Integer.parseInt(
                        editNo.getText().toString()),
                        editNoreg.getText().toString(),
                        editNama.getText().toString(),
                        editEmail.getText().toString(),
                        editTelp.getText().toString());
                students.add(tmp);
                finish();
            }
        }
    }

