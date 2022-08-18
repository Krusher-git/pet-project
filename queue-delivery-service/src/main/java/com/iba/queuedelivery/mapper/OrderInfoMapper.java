package com.iba.queuedelivery.mapper;

import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import com.iba.queuedelivery.entity.OrderInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderInfoMapper {
    @Mapping(source = "productInfoResp.productResp.id", target = "productId")
    @Mapping(source = "productInfoResp.supplierResp.id", target = "supplierId")
    @Mapping(source = "selectedAmount", target = "amount")
    @Mapping(source = "productInfoResp.price", target = "price")
    OrderInfo toEntity(final ConcreteProductInfoResp concreteProductInfoResp);

}
