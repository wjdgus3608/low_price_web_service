package com.jung.domain.product;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Product {
    @Id
    @Column(nullable = false)
    private int productId;
    private String productName;
    private String productLink;
    private String productImg;
    private int lPrice;
    private String maker;
    private String brand;

}
