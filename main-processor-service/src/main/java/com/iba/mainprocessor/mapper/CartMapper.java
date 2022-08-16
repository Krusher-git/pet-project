//package com.iba.mainprocessor.mapper;
//
//import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
//import com.iba.library.dto.req.mainprocessor.ConcreteProductReq;
//import com.iba.library.dto.resp.mainprocessor.CartResp;
//import com.iba.mainprocessor.entity.Cart;
//import org.mapstruct.Context;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Mapper(componentModel = "spring",
//        uses = {ProductMapper.class
////                ,
////                ProductCostAndSupplierMapper.class
//}
//)
//public interface CartMapper {
//    CartResp toResponse(final Cart cart);
//
//    @Mapping(target = "userId", ignore = true)
//    @Mapping(source = "concreteProducts",
//            target = "products", qualifiedByName = "concreteProductsConverter")
//    Cart toEntityFromUpdate(final CartUpdateReq cartUpdateReq, @Context final ProductCostAndSupplierRepository productCostAndSupplierRepository);
//
//    @Named("concreteProductsConverter")
//    default Set<ProductCostAndSupplier> concreteProductsConverter(Set<ConcreteProductReq> concreteProducts, @Context ProductCostAndSupplierRepository productCostAndSupplierRepository) {
//        Set<ProductCostAndSupplier> products = new HashSet<>();
//        concreteProducts.forEach(concreteProduct -> {
//            final Long productId = concreteProduct.getProductId();
//            final Long supplierId = concreteProduct.getSupplierId();
//
//            final ProductCostAndSupplier prod = productCostAndSupplierRepository.findByProduct_IdAndSupplier_Id(productId, supplierId)
//                    .orElseThrow(() -> new RuntimeException("FROM CartMapper: Replace with smth useful"));
//            products.add(prod);
//        });
//
//        return products;
//    }
//
//}
