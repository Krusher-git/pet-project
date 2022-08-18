package com.iba.queuedelivery.controller;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.queuedelivery.service.OrderService;
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
    public ResponseEntity<SimpleResp> processOrder(OrderReq orderReq) {
        orderService.processOrder(orderReq);

        log.info("started processing order");

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }

}
