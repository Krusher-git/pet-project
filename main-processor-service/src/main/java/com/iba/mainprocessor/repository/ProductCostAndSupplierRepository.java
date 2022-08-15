package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.ProductCostAndSupplier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCostAndSupplierRepository extends BaseLongKeyRepository<ProductCostAndSupplier> {
    Optional<ProductCostAndSupplier> findByProduct_IdAndSupplier_Id(final Long productId, final Long supplierId);

}
