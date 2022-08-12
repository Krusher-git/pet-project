package com.iba.security.repository;

import com.iba.library.repository.BaseLongKeyRepository;
import com.iba.security.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseLongKeyRepository<Role> {
    Optional<Role> findByName(final String name);
}
