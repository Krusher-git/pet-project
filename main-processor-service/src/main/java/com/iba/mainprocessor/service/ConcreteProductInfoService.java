package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ConcreteProductInfoReq;
import com.iba.mainprocessor.entity.Cart;
import com.iba.mainprocessor.entity.ConcreteProductInfo;

import java.util.Set;

public interface ConcreteProductInfoService {

    Set<ConcreteProductInfo> saveAll(final Set<ConcreteProductInfoReq> concreteProductInfoReqs, final Cart cart);

}
