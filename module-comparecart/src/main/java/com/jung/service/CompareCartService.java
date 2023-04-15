package com.jung.service;

import com.jung.domain.comparecart.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompareCartService {
    private final CompareCartRepository compareCartRepository;

    @Transactional
    public ResponseEntity<?> generateCart(String ownerId){
        CompareCart entity = CompareCart.builder()
                .ownerId(ownerId)
                .build();

        if(isDupId(ownerId)){
            return ResponseEntity.badRequest().build();
        }

        compareCartRepository.save(entity);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> removeCart(String ownerId){
        compareCartRepository.deleteByOwnerId(ownerId);
        return ResponseEntity.ok().build();
    }

    public Optional<CompareCart> searchCart(String ownerId){
        return compareCartRepository.findByOwnerId(ownerId);
    }




    @Transactional
    public ResponseEntity<?> clearCart(String ownerId){
        CompareCart searchedCart = searchCart(ownerId)
                .orElseThrow(()->new NoSuchElementException(""));
        searchedCart.clearCart();
        return ResponseEntity.ok().build();
    }



    @Transactional
    public ResponseEntity<?> addProductToCart(CartProductDTO cartProductDTO){
        CartProduct cartProduct = cartProductDTO.toEntity();
        CompareCart searchedCart = searchCart(cartProduct.getCompareCart().getOwnerId())
                .orElseThrow(()->new NoSuchElementException(""));
        //throw로 처리해야 하나...
        boolean isSuccess = searchedCart.addProduct(cartProduct);
        if(!isSuccess)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> removeProductFromCart(CartProductDTO cartProductDTO){
        CartProduct cartProduct = cartProductDTO.toEntity();
        System.out.println("cartProduct = " + cartProduct.toString());
        CompareCart searchedCart = searchCart(cartProduct.getCompareCart().getOwnerId())
                .orElseThrow(()->new NoSuchElementException(""));
        //throw로 처리해야 하나...
        boolean isSuccess = searchedCart.removeProduct(cartProduct);
        if(!isSuccess)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }



    private boolean isDupId(String ownerId){
        return compareCartRepository.findByOwnerId(ownerId).isPresent();
    }
}
