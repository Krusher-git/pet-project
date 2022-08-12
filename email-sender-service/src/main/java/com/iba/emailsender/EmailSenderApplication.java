package com.iba.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.iba"})

public class EmailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }
}
