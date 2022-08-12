package com.iba.mainprocessor.mapper;

import com.iba.library.dto.req.mainprocessor.SupplierProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.ProductCostAndSupplierResp;
import com.iba.mainprocessor.entity.Product;
import com.iba.mainprocessor.entity.ProductCostAndSupplier;
import com.iba.mainprocessor.entity.Supplier;
import com.iba.mainprocessor.repository.ProductRepository;
import com.iba.mainprocessor.repository.SupplierRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        uses = {SupplierMapper.class})
public interface ProductCostAndSupplierMapper {
    @Mapping(source = "supplier", target = "supplierResp")
    ProductCostAndSupplierResp toResponse(final ProductCostAndSupplier productCostAndSupplier);

    @Mapping(source = "productId", target = "product", qualifiedByName = "prod")
    @Mapping(source = "supplierId", target = "supplier", qualifiedByName = "supplier")
    ProductCostAndSupplier toEntity(final SupplierProductInfoReq supplierProductInfoReq, @Context SupplierRepository supplierRepository, @Context ProductRepository productRepository);

    @Named("prod")
    default Product findProdById(final Long productId, @Context ProductRepository productRepository) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("smth useful"));
    }

    @Named("supplier")
    default Supplier findSupById(final Long supplierId, @Context SupplierRepository supplierRepository){
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("smth useful"));
    }

}
