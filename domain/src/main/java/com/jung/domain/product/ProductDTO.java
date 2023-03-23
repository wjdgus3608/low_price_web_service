package com.jung.domain.product;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    int responseCode;
    String responseMessage;
}
