package com.iba.library.dto.resp.security;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResp extends SimpleIDResp {

    private String name;

    private String surname;

    private String email;

    private Boolean isUserNonLocked;

    private Long cartId;

}
