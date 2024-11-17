package com.example.Project_2.component;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class StudentValidation {

    public static boolean validateStudent(String[] data) {

        final Logger LOGGER = Logger.getLogger(StudentValidation.class.getName());

        try {
            if (data.length != 5) {
                LOGGER.log(Level.INFO,"Invalid Data: Data length is less than 5 or greater than 5");
                return false;
            }

            int id = Integer.parseInt(data[0]);
            if (id < 0) {
                LOGGER.log(Level.INFO,"Invalid Data: ID is less than 0");
                return false;
            }

            String first_name = data[1];
            if (first_name.isEmpty()) {
                LOGGER.log(Level.INFO,"Invalid Data: First Name is empty");
                return false;
            }

            float gpa = Float.parseFloat(data[2]);
            if (gpa < 0 || gpa > 5) {
                LOGGER.log(Level.INFO,"Invalid Data: GPA is less than 0 or greater than 5");
                return false;
            }

            String email = data[3];
            if (email.isEmpty()) {
                LOGGER.log(Level.INFO,"Invalid Data: Email is empty");
                return false;
            }

            String gender = data[4];
            if (gender.isEmpty()) {
                LOGGER.log(Level.INFO,"Invalid Data: Gender is empty");
                return false;
            }

        } catch (IndexOutOfBoundsException e) {
            LOGGER.log(Level.INFO,"Invalid Data: Index out of bounds");
            return false;
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO,"Invalid Data: Number format exception");
        }
        return true;
    }
}
