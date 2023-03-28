package com.jung.domain.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("Products")
public class Products {
    @Id
    private String keyword;
    private List<Product> productList;
}
