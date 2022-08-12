package com.iba.queuedelivery.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    private String id = UUID.randomUUID().toString();

    private Long userId;

    private Long productId;

    private Long supplierId;

    private Double price;

    private Integer amount;

}