package com.example.Project_2.controller;

import com.example.Project_2.model.Student;
import com.example.Project_2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger LOGGER = Logger.getLogger(StudentController.class.getName());

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Fetch a student by first name
    @GetMapping("/search")
    public ResponseEntity<Student> searchByFirstName(@RequestParam String firstName) {
        Student student = studentService.searchByFirstName(firstName);
        LOGGER.log(Level.INFO, "Searching for the student based of their first name");

        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            LOGGER.log(Level.SEVERE, "Error searching for student with first name");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/gpa-gender")
    public ResponseEntity<List<Student>> searchByGpaRangeAndGender(@RequestParam float minGpa, @RequestParam float maxGpa, @RequestParam String gender) {
        List<Student> students = studentService.searchByGpaRangeAndGender(minGpa, maxGpa, gender);
        LOGGER.log(Level.INFO, "Searching for students within GPA range and gender");

        if (students != null) {
            return ResponseEntity.ok(students);
        } else {
            LOGGER.log(Level.SEVERE, "Error searching for students within GPA range and gender");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/gpa-by-gender")
    public ResponseEntity<List<Float>> calculateGPAByGender(@RequestParam String gender) {
        List<Float> gpas = studentService.calculateGPAByGender(gender);
        LOGGER.log(Level.INFO, "Calculating GPA average by gender");

        if (gpas != null) {
            return ResponseEntity.ok(gpas);
        } else {
            LOGGER.log(Level.SEVERE, "Error calculating GPA average by gender");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
}