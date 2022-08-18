package com.iba.queuedelivery.service;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import com.iba.queuedelivery.entity.Order;
import com.iba.queuedelivery.entity.OrderInfo;
import com.iba.queuedelivery.mapper.OrderInfoMapper;
import com.iba.queuedelivery.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final OrderInfoMapper orderInfoMapper;

    private final BrokerDeliveryService brokerDeliveryService;

    //TODO: REPLACE TEMPLATE
    @Override
    @Transactional
    public void processOrder(OrderReq orderReq) {
        final Set<ConcreteProductInfoResp> productInfoResps = orderReq.getFinalOrder().getProducts();

        final Set<OrderInfo> orderInfos = new HashSet<>();
        productInfoResps.forEach(concreteProductInfoResp ->
                orderInfos.add(
                        orderInfoMapper.toEntity(concreteProductInfoResp)
                ));

        final Order order = new Order();
        order.setGoods(orderInfos);

        final Order savedOrder = orderRepository.save(order);
        final String id = savedOrder.getId();

        brokerDeliveryService.sendToEmailQueue(id, orderReq);
    }

}
