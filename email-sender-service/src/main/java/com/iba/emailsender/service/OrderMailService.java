package com.iba.emailsender.service;

import com.iba.library.dto.resp.queuedelivery.OrderResp;

public interface OrderMailService {

    void sendDetailOrderMail(final OrderResp orderResp);

}
