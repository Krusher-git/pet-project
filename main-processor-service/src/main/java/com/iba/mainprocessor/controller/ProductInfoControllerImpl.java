package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ProductInfoResp;
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
    public ResponseEntity<ProductInfoResp> createProductInfo(ProductInfoReq productInfoReq) {
        final ProductInfoResp productInfoResp = productInfoService.createProductInfo(productInfoReq);

        log.info("ProductInfoController: added product with productId: " + productInfoReq.getProductId() + " and supplierId: " + productInfoReq.getSupplierId());

        return ResponseEntity
                .ok()
                .body(productInfoResp);
    }

}


