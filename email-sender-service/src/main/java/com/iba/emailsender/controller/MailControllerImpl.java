package com.iba.emailsender.controller;

import com.iba.emailsender.service.MailService;
import com.iba.library.dto.req.emailsender.SimpleMailReq;
import com.iba.library.dto.resp.SimpleResp;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class MailControllerImpl implements MailController {

    private final MailService mailService;

    @Override
    public ResponseEntity<SimpleResp> sendSimpleMail(SimpleMailReq simpleMailReq) {

        mailService.sendSimpleMail(simpleMailReq);

        log.info("MailController.sendSimpleMail: sending mail with recipient: " + simpleMailReq.getRecipient());

        return ResponseEntity
                .ok()
                .body(new SimpleResp());
    }

}
