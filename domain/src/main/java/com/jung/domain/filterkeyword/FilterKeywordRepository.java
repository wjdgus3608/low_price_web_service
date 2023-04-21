package com.jung.domain.filterkeyword;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilterKeywordRepository extends JpaRepository<FilterKeyword,Long> {
    List<FilterKeyword> findByOwnerId(String ownerId);
    Optional<FilterKeyword> findByOwnerIdAndSearchKeyword(String ownerId, String searchKeyword);
}
