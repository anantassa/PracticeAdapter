package com.example.tassa.practiceadaptor;

/**
 * Created by Lenovo on 23/10/2016.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private Adapter studentArrayAdapter;
    static ArrayList<Student> studentList;
    private ListView studentListView;
   StudentStatic studentStatic = new StudentStatic();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);


        //setlistener for floacting action bar
        FloatingActionButton addStudentButton = (FloatingActionButton)findViewById(R.id.addFloatingActionButton);
        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open Form Add Student
                Intent intent = new Intent(StudentActivity.this, FormAddStudent.class);
                intent.putExtra("action","add");
                startActivity(intent);
            }
        });

        studentListView = (ListView) findViewById(R.id.list_item);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(StudentActivity.this, FormAddStudent.class);
                //we want to pass two data: action mode, and student info
                intent.putExtra("action","edit");
                Student student = studentStatic.studentList.get(position);
                intent.putExtra("student_info",student);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        //prepare emptyView
        TextView mEmptyTextView =(TextView) findViewById(R.id.empty_view);
        studentListView.setEmptyView(mEmptyTextView);
        //check size of student list
        if(studentStatic.studentList.size()==0) {
            studentArrayAdapter = new Adapter(this, new ArrayList<Student>());
            //set emptyView
            mEmptyTextView.setText("No Student Found");
        } else{
            studentArrayAdapter = new Adapter(this, StudentStatic.getList());
        }
        studentListView.setAdapter(studentArrayAdapter);
    }

    private void populateStudentDummies(){
        int i = studentStatic.studentList.size();
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(new Student(i, "3145136188","TRI FEBRIANA SIAMI","0858xxxxxx","tri@mhs.unj.ac.id"));
        studentArrayList.add(new Student(i+1, "3145136192","Ummu Kultsum","0813xxxxxx","ummu@mhs.unj.ac.id"));
        studentStatic.studentList.addAll(studentList);
        studentArrayAdapter = new Adapter(this, studentStatic.getList());
        studentListView.setAdapter(studentArrayAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_student_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.create_dummy:
                populateStudentDummies();
                return true;
            case R.id.clear_list:
                studentStatic.studentList.clear();
                studentArrayAdapter = new Adapter(this, new ArrayList<Student>());
                studentListView.setAdapter(studentArrayAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

