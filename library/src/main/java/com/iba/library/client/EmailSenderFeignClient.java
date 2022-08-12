package com.iba.library.client;

import com.iba.library.dto.req.emailsender.SimpleMailReq;
import com.iba.library.dto.resp.SimpleResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-sender-service")
public interface EmailSenderFeignClient {

    //    EMAIL PART
    @PostMapping("/pet/v1/email-sender-service/mail")
    ResponseEntity<SimpleResp> sendSimpleMail(@RequestBody SimpleMailReq simpleMailReq);

}
