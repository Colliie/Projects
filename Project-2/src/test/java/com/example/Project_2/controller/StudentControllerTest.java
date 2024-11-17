package com.example.Project_2.controller;

import com.example.Project_2.component.StudentFileReader;
import com.example.Project_2.model.Student;
import com.example.Project_2.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    private static final Logger LOGGER = Logger.getLogger(StudentControllerTest.class.getName());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @MockBean
    private StudentFileReader studentFileReader;

    private List<Student> students;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        LOGGER.log(Level.INFO, "Setting up mock tests for StudentController");

        students = List.of(
                new Student(1, "Alex", 3.5f, "Male", "alex@example.com"),
                new Student(2, "Meba", 3.6f, "Male", "meba@example.com")
        );
        LOGGER.log(Level.INFO, "Mock student data: " + students);
        when(studentFileReader.parseFile(anyString())).thenReturn(students);
    }

    @Test
    public void testSearchByFirstName() throws Exception {
        if (!students.isEmpty()) {
            when(studentService.searchByFirstName("Caleb")).thenReturn(new Student(3, "Caleb", 3.7f, "Male", "caleb@example.com"));

            mockMvc.perform(get("/students/search")
                            .param("firstName", "Caleb"))
                            .andExpect(status().isOk())
                            .andExpect(content().string(containsString("Caleb")));
        } else {
            LOGGER.log(Level.SEVERE, "Students list is empty.");
        }
    }

    @Test
    public void testSearchByGpaRangeAndGender() throws Exception {
        if (!students.isEmpty()) {
            when(studentService.searchByGpaRangeAndGender(3.0f, 4.5f, "Male")).thenReturn(students);
            mockMvc.perform(get("/students/gpa-gender")
                            .param("minGpa", "3.0")
                            .param("maxGpa", "4.5")
                            .param("gender", "Male"))
                            .andExpect(status().isOk())
                            .andExpect(content().string(containsString("Alex")))
                            .andExpect(content().string(containsString("Meba")));
        } else {
            LOGGER.log(Level.SEVERE, "Students list is empty");
        }
    }

    @Test
    public void testCalculateGPAByGender() throws Exception {
        if (!students.isEmpty()) {
            when(studentService.calculateGPAByGender("male")).thenReturn(List.of(3.25f));

            mockMvc.perform(get("/students/gpa-by-gender")
                    .param("gender", "male"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("3.25")));
        } else {
            LOGGER.log(Level.SEVERE, "Students list is empty or incorrect calculations");
        }
    }
}