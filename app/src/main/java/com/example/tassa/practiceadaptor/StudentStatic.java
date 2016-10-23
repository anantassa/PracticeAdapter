package com.example.tassa.practiceadaptor;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23/10/2016.
 */

public class StudentStatic {
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static ArrayList<Student> getList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        StudentStatic.studentList = studentList;
    }
}
