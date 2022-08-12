package com.iba.emailsender.service;

import com.iba.library.dto.req.emailsender.SimpleMailReq;

public interface MailService {

    void sendSimpleMail(final SimpleMailReq simpleMailReq);

}
