package com.jung.domain.comparecart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CompareCartRepository extends JpaRepository<CompareCart,Long> {
    Optional<CompareCart> findByOwnerId(String ownerId);
    void deleteByOwnerId(String ownerId);
}
