package com.example.passportinternship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PassportInternshipApplication {
    public static void main(String[] args) {

        SpringApplication.run(PassportInternshipApplication.class, args);
        System.out.println("Application started");
    }
}
