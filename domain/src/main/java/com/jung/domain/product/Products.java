package com.jung.domain.product;

import com.jung.domain.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash(value = "Products",timeToLive = 300000L)
public class Products {
    @Id
    private String keyword;
    private List<Product> productList;
}
