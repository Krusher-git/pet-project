package com.iba.emailsender.service;

import com.iba.library.dto.req.emailsender.SimpleMailReq;
import com.iba.library.dto.resp.queuedelivery.OrderResp;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Log4j2
public class OrderMailServiceImpl implements OrderMailService {

    private final MailService mailService;

    @Override
    @Transactional
    public void sendDetailOrderMail(OrderResp orderResp) {
//        TODO: get by ids all info from main-processor or change orderResp to contain all needed data
        String recipient = "vlad.kozich236@gmail.com";
        String subject = "order";
        String message = orderResp.toString();
        mailService.sendSimpleMail(new SimpleMailReq(recipient, subject, message));
    }

}
