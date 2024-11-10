package com.example.student_record.service;

import com.example.student_record.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class JSONDataService {

    private static final String DATA_FILE_URL = "https://hccs-advancejava.s3.amazonaws.com/student_course.json";

    @Autowired
    private RestTemplate restTemplate;

    public List<Student> fetchStudentInfo() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonData = restTemplate.getForObject(DATA_FILE_URL, String.class);
            return mapper.readValue(jsonData, new TypeReference<List<Student>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to read student data from " + DATA_FILE_URL);
            return Collections.emptyList();
        }
    }
}