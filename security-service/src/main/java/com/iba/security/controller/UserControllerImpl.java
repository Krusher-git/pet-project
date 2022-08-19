package com.iba.security.controller;

import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.security.UserResp;
import com.iba.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResp> createUser(UserReq userReq) {

        final UserResp userResp = userService.createUser(userReq);

        log.info("UserController.createUser: User with email " + userReq.getEmail() + " is created");

        return ResponseEntity
                .ok()
                .body(userResp);
    }

    @Override
    public ResponseEntity<UserResp> getUserById(Long id) {
        final UserResp userResp = userService.getUserById(id);

        log.info("UserController.getUserById: User with id " + id + " was issued");

        return ResponseEntity
                .ok()
                .body(userResp);
    }

}
