package com.iba.mainprocessor.mapper;

import com.iba.library.dto.req.mainprocessor.BasicProductInfoReq;
import com.iba.library.dto.req.mainprocessor.ConcreteProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ConcreteProductInfoResp;
import com.iba.mainprocessor.entity.Cart;
import com.iba.mainprocessor.entity.ConcreteProductInfo;
import com.iba.mainprocessor.entity.ProductInfo;
import com.iba.mainprocessor.repository.ProductInfoRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        uses = {ProductInfoMapper.class})
public interface ConcreteProductInfoMapper {

    @Mapping(source = "productInfo", target = "productInfoResp")
    ConcreteProductInfoResp toResponse(final ConcreteProductInfo concreteProductInfo);

    @Mapping(source = "concreteProductInfoReq.productInfoReq", target = "productInfo", qualifiedByName = "getProductInfo")
    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "cart", ignore = true)
    ConcreteProductInfo toEntity(final ConcreteProductInfoReq concreteProductInfoReq, final Cart cart, @Context final ProductInfoRepository productInfoRepository);

    @Named("getProductInfo")
    default ProductInfo getProductInfo(final BasicProductInfoReq productInfoReq, @Context final ProductInfoRepository productInfoRepository) {
        final Long productId = productInfoReq.getProductId();
        final Long supplierId = productInfoReq.getSupplierId();

        return productInfoRepository.findByProduct_IdAndSupplier_Id(productId, supplierId)
                .orElseThrow(() -> new RuntimeException("saa"));
    }

}
