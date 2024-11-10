package com.example.student_record.service;

import com.example.student_record.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private static JSONDataService jsonDataService;

    public static List<Course> findCourse(String courseNo) {
        return jsonDataService.fetchStudentInfo().stream()
                .flatMap(s -> s.getCourses().stream())
                .filter(c -> c.getCourseNo().equalsIgnoreCase(courseNo))
                .collect(Collectors.toList());
    }

}
