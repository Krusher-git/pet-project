package com.iba.library.dto.resp.queuedelivery;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResp {

    private String id;

    private Long userId;

    private Long productId;

    private Long supplierId;

    private Double price;

    private Integer amount;

}
