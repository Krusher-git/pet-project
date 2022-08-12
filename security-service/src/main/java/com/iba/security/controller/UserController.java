package com.iba.security.controller;

import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.security.UserResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {

    @PostMapping
    ResponseEntity<UserResp> createUser(@RequestBody UserReq userReq);

    @GetMapping("/{id}")
    ResponseEntity<UserResp> getUserById(@PathVariable Long id);

}
