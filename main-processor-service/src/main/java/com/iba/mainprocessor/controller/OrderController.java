package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.resp.SimpleResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public interface OrderController {

    @PostMapping
    ResponseEntity<SimpleResp> sendForProcessing(@RequestBody CartForOrderReq cartForOrderReq);

}
