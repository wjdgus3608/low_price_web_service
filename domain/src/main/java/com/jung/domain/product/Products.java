package com.jung.domain.product;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

//캐시 5분동안만 유지
@RedisHash(value = "Products",timeToLive = 300000L)
@Builder
public class Products {
    @Id
    private String keyword;
    private List<Product> productList;
}
