package com.jung.domain.product;

import com.jung.domain.BaseEntity;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Product {
    private long productId;
    private String productName;
    private String productLink;
    private String productImg;
    private long lPrice;
    private String maker;
    private String brand;
}
