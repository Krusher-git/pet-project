package com.iba.mainprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.iba"})
public class MainProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainProcessorApplication.class, args);
    }
}
