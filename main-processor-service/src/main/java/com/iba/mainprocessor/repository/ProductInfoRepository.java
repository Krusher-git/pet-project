package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.ProductInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends BaseLongKeyRepository<ProductInfo> {

}
