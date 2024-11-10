package com.example.student_record.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private String id;
    private String firstName;
    private List<Course> courses;
    private String gender;
    private String email;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("courses")
    public List<Course> getCourses() {
        return courses;
    }

    @JsonProperty("course")
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonCreator
    public Student(@JsonProperty("id") String id,
                   @JsonProperty("first_name") String firstName,
                   @JsonProperty("course") List<Course> courses,
                   @JsonProperty("gender") String gender,
                   @JsonProperty("email") String email) {
        this.id = id;
        this.firstName = firstName;
        this.courses = courses != null ? courses : new ArrayList<>(); // Ensure courses is not null
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {

        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", courses=" + courses +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


