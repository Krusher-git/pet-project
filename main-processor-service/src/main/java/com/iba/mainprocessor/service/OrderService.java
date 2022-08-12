package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;

public interface OrderService {
    void sendForProcessing(final CartForOrderReq cartForOrderReq);

}
