package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ProductInfoReq;
import com.iba.mainprocessor.entity.ProductInfo;
import com.iba.mainprocessor.mapper.ProductInfoMapper;
import com.iba.mainprocessor.repository.ProductInfoRepository;
import com.iba.mainprocessor.repository.ProductRepository;
import com.iba.mainprocessor.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Log4j2
public class ProductInfoServiceImpl implements ProductInfoService {

    private final ProductInfoRepository productInfoRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final ProductInfoMapper productInfoMapper;

    @Override
    @Transactional
    public void createProductInfo(ProductInfoReq productInfoReq) {
        final ProductInfo newProductInfo = productInfoMapper.toEntity(productInfoReq, productRepository, supplierRepository);

        final ProductInfo savedProduct = productInfoRepository.save(newProductInfo);


    }

}
