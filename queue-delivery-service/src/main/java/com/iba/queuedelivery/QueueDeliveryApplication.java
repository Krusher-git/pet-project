package com.iba.queuedelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.iba"})
//@EnableMongoRepositories(basePackages = {"com.iba"})
public class QueueDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueDeliveryApplication.class, args);
    }

}
