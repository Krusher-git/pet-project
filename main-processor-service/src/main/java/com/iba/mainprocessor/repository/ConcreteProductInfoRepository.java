package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.ConcreteProductInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteProductInfoRepository extends BaseLongKeyRepository<ConcreteProductInfo> {

}
