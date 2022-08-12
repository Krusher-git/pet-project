package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import com.iba.mainprocessor.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductResp> createProduct(ProductReq productReq) {
        final ProductResp productResp = productService.createProduct(productReq);

        log.info("New product is in creating process, with name " + productReq.getName());

        return ResponseEntity
                .ok()
                .body(productResp);
    }

    @Override
    public ResponseEntity<ProductResp> getProductById(Long id) {

        final ProductResp productResp = productService.getById(id);

        log.info("product with id " + id + " was issued");

        return ResponseEntity
                .ok()
                .body(productResp);
    }

}
