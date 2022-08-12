package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.mainprocessor.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Override
    public ResponseEntity<SimpleResp> sendForProcessing(CartForOrderReq cartForOrderReq) {

        log.info("sending cart to order");

        orderService.sendForProcessing(cartForOrderReq);

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }

}
