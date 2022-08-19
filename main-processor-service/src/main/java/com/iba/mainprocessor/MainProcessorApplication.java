package com.iba.mainprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.iba"})
@EnableFeignClients(basePackages = {"com.iba"})
public class MainProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainProcessorApplication.class, args);
    }
}
