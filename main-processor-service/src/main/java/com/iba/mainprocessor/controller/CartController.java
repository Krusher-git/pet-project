package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
public interface CartController {

    @PostMapping("/{userId}")
    ResponseEntity<SimpleResp> createCartWithUserId(@PathVariable Long userId);

    @GetMapping("/{userId}")
    ResponseEntity<CartResp> getCartByUserId(@PathVariable Long userId);

    @PutMapping
    ResponseEntity<CartResp> getCartByUserId(@RequestBody CartUpdateReq cartUpdateReq);

}
