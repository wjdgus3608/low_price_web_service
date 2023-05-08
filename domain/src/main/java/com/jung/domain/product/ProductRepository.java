package com.jung.domain.product;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products,String> {
    List<Product> findByKeyword(String keyword);
}
