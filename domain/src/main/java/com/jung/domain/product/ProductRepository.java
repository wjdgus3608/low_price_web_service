package com.jung.domain.product;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products,Long> {
    List<Product> findByKeyword(String keyword);
}
