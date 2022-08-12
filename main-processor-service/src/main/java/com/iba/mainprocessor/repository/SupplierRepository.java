package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends BaseLongKeyRepository<Supplier> {
}
