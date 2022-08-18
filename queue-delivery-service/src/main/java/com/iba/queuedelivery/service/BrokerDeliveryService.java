package com.iba.queuedelivery.service;

import com.iba.library.dto.req.queuedelivery.OrderReq;

public interface BrokerDeliveryService {
    void sendToEmailQueue(final String id, final OrderReq orderReq);

}
