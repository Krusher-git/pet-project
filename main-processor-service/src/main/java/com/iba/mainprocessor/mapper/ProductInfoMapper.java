package com.iba.mainprocessor.mapper;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ProductInfoResp;
import com.iba.mainprocessor.entity.Product;
import com.iba.mainprocessor.entity.ProductInfo;
import com.iba.mainprocessor.entity.Supplier;
import com.iba.mainprocessor.repository.ProductRepository;
import com.iba.mainprocessor.repository.SupplierRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        uses = {ProductMapper.class, SupplierMapper.class})
public interface ProductInfoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "productId", target = "product", qualifiedByName = "toProductEntity")
    @Mapping(source = "supplierId", target = "supplier", qualifiedByName = "toSupplierEntity")
    ProductInfo toEntity(final ProductInfoReq productInfoReq,
                         @Context ProductRepository productRepository,
                         @Context SupplierRepository supplierRepository);

    @Named("toProductEntity")
    default Product toProductEntity(final Long productId, @Context ProductRepository productRepository) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("replace with smth useful"));
    }

    @Named("toSupplierEntity")
    default Supplier toSupplierEntity(final Long supplierId, @Context SupplierRepository supplierRepository) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("replace with smth useful"));
    }
    @Mapping(source = "product", target = "productResp")
    @Mapping(source = "supplier", target = "supplierResp")
    ProductInfoResp toResponse(final ProductInfo productInfo);

}
