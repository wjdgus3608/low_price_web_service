package com.jung.domain.filterkeyword;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

public interface FilterKeywordRepository extends CrudRepository<FilterKeyword,Long> {
    List<FilterKeyword> findByOwnerId(String ownerId);
}
