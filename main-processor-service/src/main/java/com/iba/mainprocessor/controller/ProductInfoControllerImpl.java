package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.mainprocessor.service.ProductInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class ProductInfoControllerImpl implements ProductInfoController {
    private final ProductInfoService productInfoService;

    @Override
    public ResponseEntity<SimpleResp> createProductInfo(ProductInfoReq productInfoReq) {
        productInfoService.createProductInfo(productInfoReq);

        log.info("Supplier with id " + productInfoReq.getSupplierId() + "was issued to renew product with id " + productInfoReq.getProductId());

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }
}


