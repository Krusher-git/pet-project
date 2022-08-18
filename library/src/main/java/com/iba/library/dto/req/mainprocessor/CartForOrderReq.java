package com.iba.library.dto.req.mainprocessor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CartForOrderReq {

    private Long id;

    private Set<ConcreteProductInfoReq> finalProducts;

}
