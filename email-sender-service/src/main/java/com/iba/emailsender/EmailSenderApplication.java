package com.iba.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.iba"})
@EnableFeignClients(basePackages = {"com.iba"})
public class EmailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }
}
