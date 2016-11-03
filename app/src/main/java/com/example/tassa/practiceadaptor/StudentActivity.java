package com.example.tassa.practiceadaptor;

/**
 * Created by Lenovo on 23/10/2016.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {



        private Adapter adapter;
        private FloatingActionButton addButton;
        private ListView listView;
        static ArrayList<Student> students;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);

            if (students == null) {
                students = new ArrayList<Student>();
            }
            adapter = new Adapter(this, students);
            listView = (ListView) findViewById(R.id.list_item);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Student studentItem = students.get(position);
                    Intent i = new Intent(StudentActivity.this, EditStudent.class);
                    i.putExtra("student", (Serializable) studentItem);
                    i.putExtra("isEdit", true);
                    i.putExtra("position", position);
                    startActivity(i);
                }
            });

            addButton = (FloatingActionButton) findViewById(R.id.addFloatingActionButton);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(StudentActivity.this, FormAddStudent.class);
                    startActivity(i);
                }
            });


        }



        @Override
        public void onResume() {
            super.onResume();
            //prepare emptyView
            TextView emptyTV = (TextView) findViewById(R.id.empty_view);
            listView.setEmptyView(emptyTV);
            //check size of student list
            if (students.size() > 0) {
                emptyTV.setText("");
            } else {

                listView.setEmptyView(emptyTV);
                //set emptyView
                emptyTV.setText("No Student Found");
            }
            listView.setAdapter(adapter);
        }


        //public createDummy
        //int i = students.size();
        public void createDummy() {
            int i = students.size();
            students.add(new Student(i, "3145136188", "Tri Febriana Siami", "tri_unj@gmail.com", "085781897068"));
            students.add(new Student(i + 1, "3145136192", "Ummu Kultsum", "ummu_unj@gmail.com", "0888888888"));
            adapter = new Adapter(this, students);
            listView.setAdapter(adapter);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater i = getMenuInflater();
            i.inflate(R.menu.menu_student_list, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.create_dummy:
                    createDummy();
                    return true;
                case R.id.clear_list:
                    students.clear();
                    adapter = new Adapter(this, students);
                    listView.setAdapter(adapter);
                    return  true;

            }

            return super.onOptionsItemSelected(item);
        }
    }