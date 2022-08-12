package com.iba.queuedelivery.service;

import com.iba.queuedelivery.entity.Order;

public interface BrokerDeliveryService {
    void sendToQueue(final Order order);

}
