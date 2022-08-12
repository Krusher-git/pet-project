package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public void sendForProcessing(CartForOrderReq cartForOrderReq) {

    }

}
