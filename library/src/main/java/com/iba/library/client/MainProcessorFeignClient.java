package com.iba.library.client;

import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "main-processor-service")
public interface MainProcessorFeignClient {

    //    CART PART
    @PostMapping("/pet/v1/main-processor-service/cart/{userId}")
    ResponseEntity<SimpleResp> createCartWithUserId(@PathVariable Long userId);

    @GetMapping("/pet/v1/main-processor-service/cart/{userId}")
    ResponseEntity<CartResp> getCartByUserId(@PathVariable Long userId);

    @PutMapping("/pet/v1/main-processor-service/cart")
    ResponseEntity<CartResp> getCartByUserId(@RequestBody CartUpdateReq cartUpdateReq);

    //    PRODUCT PART
    @PostMapping("/pet/v1/main-processor-service/product")
    ResponseEntity<ProductResp> createProduct(@RequestBody ProductReq productReq);

    @GetMapping("/pet/v1/main-processor-service/product/{id}")
    ResponseEntity<ProductResp> getProductById(@PathVariable Long id);

    //    SUPPLIER PART
    @GetMapping("/pet/v1/main-processor-service/supplier/{id}")
    ResponseEntity<SupplierResp> getSupplierById(@PathVariable Long id);

}
