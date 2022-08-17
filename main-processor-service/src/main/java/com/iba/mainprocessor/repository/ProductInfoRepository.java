package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductInfoRepository extends BaseLongKeyRepository<ProductInfo> {
    Optional<ProductInfo> findByProduct_IdAndSupplier_Id(final Long productId, final Long supplierId);

}
