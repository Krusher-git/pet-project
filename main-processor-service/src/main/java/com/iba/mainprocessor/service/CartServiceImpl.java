package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.req.mainprocessor.ConcreteProductInfoReq;
import com.iba.library.dto.resp.mainprocessor.CartResp;
import com.iba.mainprocessor.entity.Cart;
import com.iba.mainprocessor.entity.ConcreteProductInfo;
import com.iba.mainprocessor.mapper.CartMapper;
import com.iba.mainprocessor.repository.CartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    private final ConcreteProductInfoService concreteProductInfoService;

    @Override
    public CartResp createCartWithUserId(Long userId) {
        cartRepository.findCartByUserId(userId)
                .ifPresent(cart -> {

                    log.error("CartService.CartRepository: Error! Cart with userId " + userId + " exists");

                    throw new RuntimeException("smth useful");
                });

        log.info("\n\tCartService: Creating cart for user with id " + userId);

        final Cart newCart = new Cart();
        newCart.setUserId(userId);

        cartRepository.save(newCart);

        return cartMapper.toResponse(newCart);
    }

    @Override
    public CartResp getCartByUserId(Long userId) {

        final Cart cart = cartRepository.findCartByUserId(userId)
                .orElseThrow(() -> {

                    log.error("CartService.CartRepository: Error while getting cart with userId " + userId);

                    return new RuntimeException("smth useful");
                });

        return cartMapper.toResponse(cart);
    }

    @Override
    @Transactional
    public CartResp updateCart(CartUpdateReq cartUpdateReq) {

        final Long id = cartUpdateReq.getId();
        final Set<ConcreteProductInfoReq> concreteProductInfoReqs = cartUpdateReq.getConcreteProducts();
        final Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> {

                    log.error("CartService.CartRepository: Error while getting cart with userId " + id);

                    return new RuntimeException("smth useful");
                });

        Set<ConcreteProductInfo> concreteProductInfos = concreteProductInfoService.saveAll(concreteProductInfoReqs, cart);

        cart.setProducts(concreteProductInfos);

        return cartMapper.toResponse(cart);
    }


}
