package com.iba.library.dto.req.queuedelivery;

import com.iba.library.dto.resp.mainprocessor.CartResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReq {

    private CartResp finalOrder;

}
