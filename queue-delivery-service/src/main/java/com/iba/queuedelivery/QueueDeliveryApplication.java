package com.iba.queuedelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.iba"})
@EnableFeignClients(basePackages = {"com.iba"})
public class QueueDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueDeliveryApplication.class, args);
    }

}
