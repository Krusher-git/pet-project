package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.ConcreteProductInfoReq;
import com.iba.mainprocessor.entity.Cart;
import com.iba.mainprocessor.entity.ConcreteProductInfo;
import com.iba.mainprocessor.mapper.ConcreteProductInfoMapper;
import com.iba.mainprocessor.repository.ConcreteProductInfoRepository;
import com.iba.mainprocessor.repository.ProductInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Log4j2
public class ConcreteProductInfoServiceImpl implements ConcreteProductInfoService {
    private final ConcreteProductInfoMapper concreteProductInfoMapper;
    private final ConcreteProductInfoRepository concreteProductInfoRepository;

//    private final CartRepository cartRepository;

    private final ProductInfoRepository productInfoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Set<ConcreteProductInfo> saveAll(Set<ConcreteProductInfoReq> concreteProductInfoReqs, Cart cart) {
//        final Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("sa"));
        final Set<ConcreteProductInfo> productInfos =
                concreteProductInfoReqs.stream()
                        .map(concreteProductInfoReq -> concreteProductInfoMapper.toEntity(concreteProductInfoReq, cart, productInfoRepository))
                        .collect(Collectors.toSet());

        return new HashSet<>(concreteProductInfoRepository.saveAll(productInfos));
    }

}
