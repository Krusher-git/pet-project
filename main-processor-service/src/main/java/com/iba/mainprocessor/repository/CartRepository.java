package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends BaseLongKeyRepository<Cart> {
    Optional<Cart> findCartByUserId(final Long userId);
}
