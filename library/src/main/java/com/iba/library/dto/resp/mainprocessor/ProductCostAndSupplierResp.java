package com.iba.library.dto.resp.mainprocessor;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCostAndSupplierResp extends SimpleIDResp {

    private SupplierResp supplierResp;

    private Double cost;

    private Integer amount;

}
