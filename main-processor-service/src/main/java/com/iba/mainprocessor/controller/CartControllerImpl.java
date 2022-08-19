package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.SimpleIDResp;
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
    public ResponseEntity<SimpleIDResp> createCartWithUserId(Long userId) {
        final CartResp cartResp = cartService.createCartWithUserId(userId);

        log.info("CartController.createCartWithUserId: Cart with userId " + userId + " is in creating process");

        return ResponseEntity
                .ok()
                .body(new SimpleIDResp(cartResp.getId()));
    }

    @Override
    public ResponseEntity<CartResp> getCartByUserId(Long userId) {
        final CartResp cartResp = cartService.getCartByUserId(userId);

        log.info("CartController.getCartByUserId: Cart with userId " + userId + " was issued");

        return ResponseEntity
                .ok()
                .body(cartResp);
    }

    @Override
    public ResponseEntity<CartResp> updateCart(CartUpdateReq cartUpdateReq) {
        final CartResp cartResp = cartService.updateCart(cartUpdateReq);

        log.info("CartController.updateCart: Cart with id " + cartUpdateReq.getId() + " was issued to update");

        return ResponseEntity
                .ok()
                .body(cartResp);
    }

    @Override
    public ResponseEntity<CartResp> sendForProcessing(CartForOrderReq cartForOrderReq) {

        log.info("CartController.sendForProcessing: Cart with id " + cartForOrderReq.getId() + " is sending");

        final CartResp finalOrder = cartService.sendForProcessing(cartForOrderReq);

        return ResponseEntity
                .ok()
                .body(finalOrder);
    }

}
