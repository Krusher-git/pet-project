package com.iba.mainprocessor.controller;

import com.iba.library.dto.req.mainprocessor.SupplierProductInfoReq;
import com.iba.library.dto.resp.SimpleResp;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import com.iba.mainprocessor.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class SupplierControllerImpl implements SupplierController {

    private final SupplierService supplierService;

    @Override
    public ResponseEntity<SupplierResp> getSupplierById(final Long id) {
        final SupplierResp supplierResp = supplierService.getById(id);

        log.info("Supplier with id " + id + "was issued");

        return ResponseEntity
                .ok()
                .body(supplierResp);
    }

    @Override
    public ResponseEntity<SimpleResp> addNewProductInfo(SupplierProductInfoReq supplierProductInfoReq) {

        supplierService.addNewProductInfo(supplierProductInfoReq);

        log.info("Supplier with id " + supplierProductInfoReq.getSupplierId() + "was issued to renew product with id " + supplierProductInfoReq.getProductId());

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }

}
