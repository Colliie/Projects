package com.example.student_record.service;

import com.example.student_record.model.Student;
import com.example.student_record.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPACalculationsService {

    private static int convertGradeToPoints(String grade) {

        return switch (grade) {
            case "A" -> 4;
            case "B" -> 3;
            case "C" -> 2;
            case "D" -> 1;
            default -> 0;
        };
    }

    public static double calculateGPA(Student student) {

        List<Course> courses = student.getCourses();
        if (courses == null || courses.isEmpty()) {
            return 0;
        }

        double totalPoints = 0;
        int totalCredits = 0;
        for (Course course : courses) {
            int points = convertGradeToPoints(course.getGrade());
            totalPoints += points * course.getCreditHours();
            totalCredits += course.getCreditHours();
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0;
    }
}