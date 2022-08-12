package com.iba.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseLongKeyRepository<T> extends JpaRepository<T, Long> {
}
