package com.jung.domain.product;

import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("Products")
public class Products {
    private List<Product> productList;
}