package com.iba.library.dto.resp.mainprocessor;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResp extends SimpleIDResp {

    private Long userId;

    private Set<ProductCostAndSupplierResp> products;

}
