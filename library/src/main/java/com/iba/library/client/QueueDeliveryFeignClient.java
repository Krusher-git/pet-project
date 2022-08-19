package com.iba.library.client;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.SimpleResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "queue-delivery-service")
public interface QueueDeliveryFeignClient {

    @PostMapping("/pet/v1/queue-delivery-service/order")
    ResponseEntity<SimpleResp> processOrder(@RequestBody OrderReq orderReq);

}
