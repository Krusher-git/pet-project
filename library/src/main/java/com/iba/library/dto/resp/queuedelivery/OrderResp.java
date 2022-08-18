package com.iba.library.dto.resp.queuedelivery;

import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResp {

    private String id;

    private Long userId;

    private Set<ConcreteProductInfoResp> products;

}
