package com.iba.mainprocessor.mapper;

import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.mainprocessor.entity.Cart;
import com.iba.mainprocessor.entity.Product;
import com.iba.mainprocessor.repository.ProductRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring",
        uses = {ProductMapper.class})
public interface CartMapper {
    CartResp toResponse(final Cart cart);

    @Mapping(target = "userId", ignore = true)
    @Mapping(source = "productIds",
            target = "products",
            qualifiedByName = "idsToProducts")
    Cart toEntityFromUpdate(final CartUpdateReq cartUpdateReq, @Context ProductRepository productRepository);

    @Named("idsToProducts")
    default Set<Product> idsToProducts(Set<Long> productIds, @Context ProductRepository productRepository) {
        Set<Product> products = new HashSet<>();

        productIds.forEach(productId -> {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("smth useful"));
            products.add(product);
        });
        return products;
    }

}
