package com.iba.queuedelivery.service;

import com.iba.library.dto.resp.queuedelivery.OrderResp;
import com.iba.queuedelivery.entity.Order;
import com.iba.queuedelivery.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import static com.iba.queuedelivery.util.BrokerConfigConstants.EMAIL_ROUTING_KEY;
import static com.iba.queuedelivery.util.BrokerConfigConstants.TOPIC_EXCHANGE_NAME;

@Service
@AllArgsConstructor
@Log4j2
public class BrokerDeliveryServiceImpl implements BrokerDeliveryService {

    private final OrderMapper orderMapper;

    private final AmqpTemplate amqpTemplate;

    @Override
    public void sendToQueue(Order order) {
        final OrderResp orderResp = orderMapper.toResponse(order);

        amqpTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, EMAIL_ROUTING_KEY, orderResp);
    }

}
