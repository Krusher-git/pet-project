package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.mainprocessor.ProductResp;

public interface ProductService {
    ProductResp createProduct(final ProductReq productReq);

    ProductResp getById(final Long id);
}
