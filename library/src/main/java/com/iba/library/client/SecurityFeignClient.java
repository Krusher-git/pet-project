package com.iba.library.client;

import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.security.UserResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "security-service")
public interface SecurityFeignClient {

    //  USER PART
    @PostMapping("/pet/v1/security-service/user")
    ResponseEntity<UserResp> createUser(@RequestBody UserReq userReq);

    @GetMapping("/pet/v1/security-service/{id}")
    ResponseEntity<UserResp> getUserById(@PathVariable Long id);

}
