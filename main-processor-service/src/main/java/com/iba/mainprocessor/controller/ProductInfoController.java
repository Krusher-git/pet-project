package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ProductInfoResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product-info")
public interface ProductInfoController {

    @PostMapping
    ResponseEntity<ProductInfoResp> createProductInfo(final @RequestBody ProductInfoReq productInfoReq);

}
