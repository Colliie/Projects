package com.example.student_record.Component;

import com.example.student_record.model.Student;
import com.example.student_record.service.GPACalculationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import com.example.student_record.service.StudentService;

@Component
public class ConsoleComponent {

    @Autowired
    private StudentService studentService;

    public void menu() {
        while (true) {

            System.out.println("""
                    1. Search for student by their first name.
                    2. Input a course number and retrieve a list of students enrolled in that course.
                    3. Exit.
                    """);

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:

                    System.out.println("What's the student's name? ");
                    String name = scanner.next();
                    List<Student> students = studentService.findStudentByFirstName(name);
                    if (students.isEmpty()) {
                        System.out.println("No students found with the name: " + name);
                    } else {
                        Student student = students.get(0);
                        System.out.println(student);
                        double gpa = GPACalculationsService.calculateGPA(student);
                        System.out.println(name + " GPA is: " + gpa);
                    }
                    break;
                case 2:

                    System.out.println("What's the course number? ");
                    String courseNu = scanner.next();
                    List<Student> studentsByCourse = studentService.findStudentByCourseNumber(courseNu);
                    if (studentsByCourse.isEmpty()) {
                        System.out.println("No students found for the course number: " + courseNu);
                    } else {
                        System.out.println("The following students enrolled in " + courseNu + ":");
                        for (Student student : studentsByCourse) {
                            System.out.println(student.getFirstName());
                        }
                    }
                    break;
                case 3:

                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}



