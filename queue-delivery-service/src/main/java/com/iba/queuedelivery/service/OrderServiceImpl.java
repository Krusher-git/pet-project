package com.iba.queuedelivery.service;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.queuedelivery.entity.Order;
import com.iba.queuedelivery.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final BrokerDeliveryService brokerDeliveryService;

    //TODO: REPLACE TEMPLATE
    @Override
    @Transactional
    public void processOrder(CartForOrderReq cartForOrderReq) {
        Long productId = cartForOrderReq
                .getProductIds()
                .stream()
                .findFirst()
                .orElse(1L);
        Long supplierId = cartForOrderReq
                .getProductIds()
                .stream()
                .findFirst()
                .orElse(2L);

        Integer amount = 2;
        Double price = 3.0;

        final Order order = new Order();

        order.setUserId(1L);
        order.setProductId(productId);
        order.setSupplierId(supplierId);
        order.setAmount(amount);
        order.setPrice(price);

        final Order savedOrder = orderRepository.save(order);

        brokerDeliveryService.sendToQueue(savedOrder);
    }

}
