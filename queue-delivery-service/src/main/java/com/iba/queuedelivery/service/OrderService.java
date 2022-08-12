package com.iba.queuedelivery.service;


import com.iba.library.dto.req.mainprocessor.CartForOrderReq;

public interface OrderService {
    void processOrder(final CartForOrderReq cartForOrderReq);

}
