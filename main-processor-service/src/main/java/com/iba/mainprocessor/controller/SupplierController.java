package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/supplier")
public interface SupplierController {
    @GetMapping("/{id}")
    ResponseEntity<SupplierResp> getSupplierById(@PathVariable Long id);

}
