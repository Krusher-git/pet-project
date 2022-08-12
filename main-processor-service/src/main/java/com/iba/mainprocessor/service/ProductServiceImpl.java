package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import com.iba.mainprocessor.entity.Product;
import com.iba.mainprocessor.mapper.ProductMapper;
import com.iba.mainprocessor.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    //TODO: add correct transaction
    @Override
    @Transactional
    public ProductResp createProduct(ProductReq productReq) {

        final Product newProduct = productMapper.toEntity(productReq);
        productRepository.save(newProduct);

        return productMapper.toResponse(newProduct);
    }

    @Override
    public ProductResp getById(Long id) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Error while getting product with id " + id);
                    return new RuntimeException("replace with smth useful");
                });

        return productMapper.toResponse(product);
    }

}
