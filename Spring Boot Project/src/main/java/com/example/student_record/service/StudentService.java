package com.example.student_record.service;

import com.example.student_record.model.Course;
import com.example.student_record.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private JSONDataService jsonDataService;

    public List<Student> findStudentByFirstName(String name) {

        return jsonDataService.fetchStudentInfo().stream()
                .filter(s -> s.getFirstName() != null && s.getFirstName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Student> findStudentByCourseNumber(String courseNu) {

        List<Student> students = jsonDataService.fetchStudentInfo(); // Fetch students
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            for (Course course : student.getCourses()) {
                if (course.getCourseNo().equalsIgnoreCase(courseNu)) {
                    result.add(student);
                    break;
                }
            }
        }
        return result;
    }
}

