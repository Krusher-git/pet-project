package com.iba.mainprocessor.mapper;

import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.mainprocessor.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {ConcreteProductInfoMapper.class}
)
public interface CartMapper {
    CartResp toResponse(final Cart cart);

}
