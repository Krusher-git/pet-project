package com.iba.queuedelivery.service;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import com.iba.queuedelivery.entity.Order;
import com.iba.queuedelivery.entity.OrderInfo;
import com.iba.queuedelivery.mapper.OrderInfoMapper;
import com.iba.queuedelivery.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final OrderInfoMapper orderInfoMapper;

    private final BrokerDeliveryService brokerDeliveryService;

    @Override
    @Transactional
    public void processOrder(OrderReq orderReq) {
        final Set<ConcreteProductInfoResp> productInfoResps = orderReq.getFinalOrder().getProducts();
        final Long userId = orderReq.getFinalOrder().getUserId();

        final Set<OrderInfo> orderInfos = new HashSet<>();
        productInfoResps.forEach(concreteProductInfoResp ->
                orderInfos.add(
                        orderInfoMapper.toEntity(concreteProductInfoResp)
                ));

        final Order order = new Order();
        order.setGoods(orderInfos);
        order.setUserId(userId);

        final Order savedOrder = orderRepository.save(order);
        final String id = savedOrder.getId();

        log.info("OrderService.processOrder: Order with id: " + id + " is created");

        brokerDeliveryService.sendToEmailQueue(id, orderReq);
    }

}
