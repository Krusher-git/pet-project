package com.iba.library.dto.req.mainprocessor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class CartUpdateReq {

    private Long id;

    private Set<Long> productIds;

}
