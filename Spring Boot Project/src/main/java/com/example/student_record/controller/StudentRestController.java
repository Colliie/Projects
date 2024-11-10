package com.example.student_record.controller;

import java.util.List;

import com.example.student_record.model.Course;
import com.example.student_record.model.Student;
import com.example.student_record.service.CourseService;
import com.example.student_record.service.GPACalculationsService;
import com.example.student_record.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GPACalculationsService gpaCalculationService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public List<Student> getStudentsByFirstName(@RequestParam String name) {
        return studentService.findStudentByFirstName(name);
    }

    @GetMapping("/courses")
    public List<Course> getCourseByCourseNumber(@RequestParam String courseNumber) {
        return courseService.findCourse(courseNumber);
    }

    @GetMapping("/gpa")
    public double getGPA(@RequestParam String name) {
        List<Student> students = studentService.findStudentByFirstName(name);
        return students.isEmpty() ? 0 : gpaCalculationService.calculateGPA(students.get(0));
    }
}
