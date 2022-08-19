package com.iba.emailsender.service;

import com.iba.library.client.SecurityFeignClient;
import com.iba.library.dto.req.emailsender.SimpleMailReq;
import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import com.iba.library.dto.resp.queuedelivery.OrderResp;
import com.iba.library.dto.resp.security.UserResp;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class OrderMailServiceImpl implements OrderMailService {

    private final MailService mailService;

    private final SecurityFeignClient securityFeignClient;
    private final String ORDER_INFO_SUBJECT = "Order Info";

    @Override
    @Transactional
    public void sendDetailOrderMail(OrderResp orderResp) {

        final Long userId = orderResp.getUserId();

        final UserResp userResp =
                securityFeignClient
                        .getUserById(userId)
                        .getBody();

        if (Objects.isNull(userResp)) {

            log.error("OrderMailService.sendDetailOrderMail: error when getting user with id: " + userId);

            throw new RuntimeException("smth useful");
        }

        final String recipient = userResp.getEmail();
        final String message = setMessage(orderResp.getProducts());

        mailService.sendSimpleMail(new SimpleMailReq(recipient, ORDER_INFO_SUBJECT, message));
    }

    private String setMessage(final Set<ConcreteProductInfoResp> products) {
        return products.stream()
                .map(this::createReadableMessage)
                .collect(
                        Collectors.joining(";\n", "Orders:\n\n", ".")
                );
    }

    private String createReadableMessage(final ConcreteProductInfoResp concreteProductInfoResp) {
        final String productName = concreteProductInfoResp.getProductInfoResp().getProductResp().getName();
        final String productDescription = concreteProductInfoResp.getProductInfoResp().getProductResp().getDescription();
        final Double productPrice = concreteProductInfoResp.getProductInfoResp().getPrice();
        final Integer productQuantity = concreteProductInfoResp.getSelectedAmount();
        final String supplierName = concreteProductInfoResp.getProductInfoResp().getSupplierResp().getName();
        return """
                Product:
                                
                    name: %s,
                    description: %s,
                    price: %.2f,
                    quantity: %x,
                    supplier name: %s""".formatted(
                productName,
                productDescription,
                productPrice,
                productQuantity,
                supplierName);
    }

}
