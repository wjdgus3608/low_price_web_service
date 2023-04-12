package com.jung.domain.comparecart;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddCartProductDTO {
    String ownerId;
    long productId;
}
