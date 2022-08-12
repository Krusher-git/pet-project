package com.iba.queuedelivery.mapper;

import com.iba.library.dto.resp.queuedelivery.OrderResp;
import com.iba.queuedelivery.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResp toResponse(final Order order);

}
