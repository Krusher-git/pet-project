package com.iba.emailsender.controller;

import com.iba.emailsender.service.OrderMailService;
import com.iba.library.dto.resp.queuedelivery.OrderResp;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@AllArgsConstructor
public class OrderListener {
    private final OrderMailService orderMailService;

    @RabbitListener(queues = "email_queue")
    public void processOrder(final OrderResp orderResp) {

        log.info("OrderListener.processOrder: processing order with id: " + orderResp.getId() + " and userId: " + orderResp.getUserId());

        orderMailService.sendDetailOrderMail(orderResp);

    }

}
