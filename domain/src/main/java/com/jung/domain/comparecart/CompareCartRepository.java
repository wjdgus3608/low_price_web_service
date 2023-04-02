package com.jung.domain.comparecart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CompareCartRepository extends JpaRepository<CompareCart,Long> {
    CompareCart findByOwnerId(String ownerId);
    ResponseEntity<?> deleteByOwnerId(String ownerId);
}
