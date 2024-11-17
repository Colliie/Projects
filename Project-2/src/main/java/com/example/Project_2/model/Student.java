package com.example.Project_2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private float gpa;
    private String email;
    private String gender;

    public Student() {}

    public Student(int id, String first_name, float gpa, String email, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public float getGpa() {return gpa;}
    public void setGpa(float gpa) {this.gpa = gpa;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
}
