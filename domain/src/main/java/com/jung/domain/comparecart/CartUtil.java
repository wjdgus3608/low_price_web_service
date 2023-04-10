package com.jung.domain.comparecart;

public class CartUtil {
    public static CompareCart generateCompareCart(String ownerId){
        return CompareCart.builder()
                .ownerId(ownerId)
                .build();
    }

    public CartProduct generateCartProduct(long id, String ownerId){

        return CartProduct.builder()
                .productId(id)
                .compareCart(generateCompareCart(ownerId))
                .build();
    }
}
