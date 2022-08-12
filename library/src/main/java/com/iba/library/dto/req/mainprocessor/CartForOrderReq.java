package com.iba.library.dto.req.mainprocessor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CartForOrderReq {

    private Long userId;

    private Set<Long> productIds;

    private Set<Long> supplierIds;

}
