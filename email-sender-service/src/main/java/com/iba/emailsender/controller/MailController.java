package com.iba.emailsender.controller;

import com.iba.library.dto.req.emailsender.SimpleMailReq;
import com.iba.library.dto.resp.SimpleResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mail")
public interface MailController {

    @PostMapping
    ResponseEntity<SimpleResp> sendSimpleMail(@RequestBody SimpleMailReq simpleMailReq);

}
