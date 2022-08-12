package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseLongKeyRepository<Product> {
}
