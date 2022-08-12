package com.iba.mainprocessor.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.mainprocessor.entity.Wishlist;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends BaseLongKeyRepository<Wishlist> {
}
