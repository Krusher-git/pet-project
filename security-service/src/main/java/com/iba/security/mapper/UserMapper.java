package com.iba.security.mapper;

import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.security.UserResp;
import com.iba.security.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isUserNonLocked", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "cartId", ignore = true)
    @Mapping(target = "wishlistId", ignore = true)
    User toEntity(final UserReq userReq);

    UserResp toResponse(final User user);

}
