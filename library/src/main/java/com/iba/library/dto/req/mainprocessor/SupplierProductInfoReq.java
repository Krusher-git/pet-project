package com.iba.library.dto.req.mainprocessor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SupplierProductInfoReq {

    private Long productId;

    private Long supplierId;

    private Double cost;

    private Integer amount;

}
