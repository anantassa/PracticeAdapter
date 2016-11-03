package com.example.tassa.practiceadaptor;

import java.io.Serializable;

/**
 * Created by Lenovo on 23/10/2016.
 */

public class Student {
    private int id; //private
    private String noreg;
    private String name;
    private String email;
    private String phone;


    public Student(int id, String noreg, String name , String email, String phone) {
        this.id= id;
        this.noreg= noreg;
        this.name= name;
        this.email = email;
        this.phone =phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String norreg) {
        this.noreg = noreg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

