package com.iba.security.service;

import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.security.UserResp;

public interface UserService {

    UserResp createUser(final UserReq userReq);

    UserResp getUserById(final Long id);

}
