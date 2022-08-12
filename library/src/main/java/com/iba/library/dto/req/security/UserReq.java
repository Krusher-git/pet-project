package com.iba.library.dto.req.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserReq {

    private String name;

    private String surname;

    private String email;

    private String password;

}
