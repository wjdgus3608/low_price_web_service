package com.jung.domain.product;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Products,String> {

    Optional<Products> findByKeyword(String keyword);
}
