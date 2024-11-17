package com.example.Project_2.service;

import com.example.Project_2.model.Student;
import com.example.Project_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@SuppressWarnings("ALL")
@Service
public class StudentService {
    private final List<Student> students;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.students = studentRepository.findAll();
    }

    public Student searchByFirstName(String firstName) {

        if (!StringUtils.hasText(firstName)) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        boolean found = false;
        Student tempStudent = null;

        for (Student student : this.students) {
            tempStudent = student;

            if ((tempStudent.getFirst_name()).toLowerCase().contains(firstName.toLowerCase())) {
                found = true;
                return tempStudent;
            }

            if (!found) {
                int firstNameLength = firstName.length();
                boolean match = firstName.regionMatches(0, tempStudent.getFirst_name(), 0, firstNameLength);

                if (match) {
                    return tempStudent;
                }
            }
        }
        return tempStudent;
    }

    public List<Student> searchByGpaRangeAndGender(float minGpa, float maxGpa, String gender) {

        if (minGpa < 0.0 || maxGpa > 4.0 || minGpa > maxGpa || (!StringUtils.hasText(gender))) {
            throw new IllegalArgumentException("Must be within 0.0 to 4.0 and minGpa cant be greater than the maxGpa. Gender has to be male or female");
        }

        List<Float> gpas = new ArrayList<>();
        for (Student student : this.students) {
            if ((student.getGpa() >= minGpa) && (student.getGpa() <= maxGpa) && (student.getGender()).toLowerCase().equals(gender.toLowerCase())) {
                gpas.add(student.getGpa());
            }
        }

        gpas.sort(Comparator.reverseOrder());
        boolean run = true;
        List<Student> sortedStudents = new ArrayList<>();

        while (run) {
            int i = 0;
            for (Student student : this.students) {
                if (gpas.get(i) == student.getGpa()) {
                    sortedStudents.add(student);
                    i++;
                }
            }
            if (i == gpas.size()) {
                run = false;
            }
        }

        return sortedStudents;
    }


    public List<Float> calculateGPAByGender(String gender) {

        if (!StringUtils.hasText(gender)) {
            throw new IllegalArgumentException("Gender has to be male or female");
        }

        float totalGpa = 0;
        int count = 0;

        for (Student student : this.students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                totalGpa += student.getGpa();
                count++;
            }
        }

        float averageGpa = count > 0 ? totalGpa / count : 0;
        return List.of(averageGpa);
    }
}