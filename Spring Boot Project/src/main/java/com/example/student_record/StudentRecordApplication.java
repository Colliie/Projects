package com.example.student_record;

import com.example.student_record.Component.ConsoleComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ConsoleComponent consoleComponent) {
		return args -> consoleComponent.menu();
	}
}
