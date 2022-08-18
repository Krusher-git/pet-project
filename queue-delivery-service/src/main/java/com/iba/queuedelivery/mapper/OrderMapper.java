package com.iba.queuedelivery.mapper;

import com.iba.library.dto.req.queuedelivery.OrderReq;
import com.iba.library.dto.resp.queuedelivery.OrderResp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "finalOrder.userId", target = "userId")
    @Mapping(source = "finalOrder.products", target = "products")
    OrderResp toResponseFromRequest(final OrderReq orderReq);

}
