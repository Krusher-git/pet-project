package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ProductInfoResp;

public interface ProductInfoService {

    ProductInfoResp createProductInfo(final ProductInfoReq productInfoReq);

}
