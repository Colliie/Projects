package com.example.student_record.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

    private String courseNo;
    private String grade;
    private int creditHours;

    @JsonProperty("courseNo")
    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    @JsonProperty("grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @JsonProperty("creditHours")
    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @JsonCreator
    public Course(@JsonProperty("courseNo") String courseNo,
                  @JsonProperty("grade") String grade,
                  @JsonProperty("creditHours") int creditHours) {
        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;
    }
}
