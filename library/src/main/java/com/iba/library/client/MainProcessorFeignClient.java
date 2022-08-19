package com.iba.library.client;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.SimpleIDResp;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.library.dto.resp.mainprocessor.ProductInfoResp;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "main-processor-service")
public interface MainProcessorFeignClient {

    //    CART PART
    @PostMapping("/pet/v1/main-processor-service/cart/{userId}")
    ResponseEntity<SimpleIDResp> createCartWithUserId(@PathVariable Long userId);

    @GetMapping("/pet/v1/main-processor-service/cart/{userId}")
    ResponseEntity<CartResp> getCartByUserId(@PathVariable Long userId);

    @PutMapping("/pet/v1/main-processor-service/cart")
    ResponseEntity<CartResp> updateCart(@RequestBody CartUpdateReq cartUpdateReq);

    @PostMapping("/pet/v1/main-processor-service/cart/order")
    ResponseEntity<CartResp> sendForProcessing(@RequestBody CartForOrderReq cartForOrderReq);

    //    PRODUCT PART
    @PostMapping("/pet/v1/main-processor-service/product")
    ResponseEntity<ProductResp> createProduct(@RequestBody ProductReq productReq);

    @GetMapping("/pet/v1/main-processor-service/product/{id}")
    ResponseEntity<ProductResp> getProductById(@PathVariable Long id);

    //    SUPPLIER PART
    @GetMapping("/pet/v1/main-processor-service/supplier/{id}")
    ResponseEntity<SupplierResp> getSupplierById(@PathVariable Long id);

    //    PRODUCT INFO PART
    @PostMapping("/pet/v1/main-processor-service/supplier/product-info")
    ResponseEntity<ProductInfoResp> createProductInfo(final @RequestBody ProductInfoReq productInfoReq);

}
