package com.example.Project_2.component;

import com.example.Project_2.model.Student;
import com.example.Project_2.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class StudentFileReader {

    private static final Logger LOGGER = Logger.getLogger(StudentFileReader.class.getName());

    @Value("${file.path:src/main/java/com/example/Project_2/students.txt}")
    private String filePath;

    private final List<Student> students = new CopyOnWriteArrayList<>();
    private final StudentRepository studentRepository;

    public StudentFileReader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void init() {
        LOGGER.log(Level.INFO, "Initializing StudentFileReader with file path: " + filePath);
        parseFile(filePath);
    }

    public List<Student> parseFile(String filePath) {
        LOGGER.log(Level.INFO, "Attempting to read file from path: " + filePath);

        if (!Files.exists(Paths.get(filePath))) {
            LOGGER.log(Level.SEVERE, "File not found: " + filePath);
            return students;
        }

        try (InputStream inputStream = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            LOGGER.log(Level.INFO, "File found, starting to parse it.");
            String line = br.readLine();
            LOGGER.log(Level.INFO, "Skipped header line: " + line);

            while ((line = br.readLine()) != null) {
                LOGGER.log(Level.INFO, "Reading line: " + line);
                String[] data = line.split(",");
                if (data.length == 5) {
                    Student student = new Student(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), data[3], data[4]);
                    students.add(student);
                    studentRepository.save(student);
                    LOGGER.log(Level.INFO, "Parsed and added student: " + student);
                } else {
                    LOGGER.log(Level.WARNING, "Invalid data line: " + line);
                }
            }
            studentRepository.saveAll(students);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error attempting to read file: " + e.getMessage(), e);
        }
        return students;
    }
}
