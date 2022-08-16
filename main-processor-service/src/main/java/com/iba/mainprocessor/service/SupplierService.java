package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import com.iba.mainprocessor.entity.Supplier;

public interface SupplierService {

    SupplierResp getById(final Long id);

}
