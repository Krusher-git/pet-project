package com.iba.queuedelivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {

    private Long productId;

    private Long supplierId;

    private Integer amount;

    private Double price;

}