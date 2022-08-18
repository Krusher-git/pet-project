package com.iba.queuedelivery.service;


import com.iba.library.dto.req.queuedelivery.OrderReq;

public interface OrderService {
    void processOrder(final OrderReq orderReq);

}
