package com.iba.queuedelivery.controller;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.SimpleResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public interface OrderController {

    @PostMapping
    ResponseEntity<SimpleResp> processOrder(@RequestBody OrderReq orderReq);

}
