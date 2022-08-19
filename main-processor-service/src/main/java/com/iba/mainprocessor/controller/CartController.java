package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.SimpleIDResp;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
public interface CartController {

    @PostMapping("/{userId}")
    ResponseEntity<SimpleIDResp> createCartWithUserId(@PathVariable Long userId);

    @GetMapping("/{userId}")
    ResponseEntity<CartResp> getCartByUserId(@PathVariable Long userId);

    @PutMapping
    ResponseEntity<CartResp> updateCart(@RequestBody CartUpdateReq cartUpdateReq);

    @PostMapping("/order")
    ResponseEntity<CartResp> sendForProcessing(@RequestBody CartForOrderReq cartForOrderReq);

}
