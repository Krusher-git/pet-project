package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.mainprocessor.service.CartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class CartControllerImpl implements CartController {

    private final CartService cartService;

    @Override
    public ResponseEntity<SimpleResp> createCartWithUserId(Long userId) {
        final CartResp cartResp = cartService.createCartWithUserId(userId);

        log.info("Cart with userId " + userId + " is in creating process");

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }

    @Override
    public ResponseEntity<CartResp> getCartByUserId(Long userId) {
        final CartResp cartResp = cartService.getCartByUserId(userId);

        log.info("Cart with userId " + userId + " was issued");

        return ResponseEntity
                .ok()
                .body(cartResp);
    }

    @Override
    public ResponseEntity<CartResp> getCartByUserId(CartUpdateReq cartUpdateReq) {
        final CartResp cartResp = cartService.updateCart(cartUpdateReq);

        log.info("Cart with id " + cartUpdateReq.getId() + " was issued to update");

        return ResponseEntity
                .ok()
                .body(cartResp);
    }

}
