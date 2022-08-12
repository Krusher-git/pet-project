package com.iba.security.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseLongKeyRepository<User> {
    Optional<User> findByEmail(final String email);
}
