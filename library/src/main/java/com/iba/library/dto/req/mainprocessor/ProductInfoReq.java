package com.iba.library.dto.req.mainprocessor;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductInfoReq {

    private Long productId;

    @NotNull
    private Long supplierId;

    private Double price;

    private Integer availableAmount;

}
