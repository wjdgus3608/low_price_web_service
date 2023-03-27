package com.jung.domain.product;

import lombok.*;


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
