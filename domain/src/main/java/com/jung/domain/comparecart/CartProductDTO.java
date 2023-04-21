package com.jung.domain.comparecart;

import com.jung.domain.RequestDTO;
import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDTO implements RequestDTO<CartProduct> {
    @NotNull
    private String ownerId;
    @NotNull
    private long productId;


    @Override
    public CartProduct toEntity() {
        return CartUtil.generateCartProduct(this.getProductId(),this.getOwnerId());
    }
}
