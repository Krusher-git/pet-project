package com.iba.library.dto.resp.mainprocessor;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoResp extends SimpleIDResp {

    private ProductResp productResp;

    private SupplierResp supplierResp;

    private Double price;

    private Integer availableAmount;

}
