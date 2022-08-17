package com.iba.library.dto.req.mainprocessor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ConcreteProductInfoReq {

    private BasicProductInfoReq productInfoReq;

    private Integer selectedAmount;

}
