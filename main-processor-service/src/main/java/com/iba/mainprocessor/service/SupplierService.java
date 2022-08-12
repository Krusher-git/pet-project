package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.SupplierProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;

public interface SupplierService {

    SupplierResp getById(final Long id);

    void addNewProductInfo(final SupplierProductInfoReq supplierProductInfoReq);

}
