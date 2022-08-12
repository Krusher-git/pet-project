package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
public interface ProductController {

    @PostMapping
    ResponseEntity<ProductResp> createProduct(@RequestBody ProductReq productReq);

    @GetMapping("/{id}")
    ResponseEntity<ProductResp> getProductById(@PathVariable Long id);

}
