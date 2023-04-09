package com.jung.service;

import com.jung.domain.comparecart.CartProduct;
import com.jung.domain.comparecart.CompareCart;
import com.jung.domain.comparecart.CompareCartRepository;
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
    public ResponseEntity<?> addProductToCart(CartProduct cartProduct){
        CompareCart searchedCart = searchCart(cartProduct.getCompareCart().getOwnerId())
                .orElseThrow(()->new NoSuchElementException(""));
        searchedCart.addProduct(cartProduct);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> removeProductFromCart(CartProduct cartProduct){
        CompareCart searchedCart = searchCart(cartProduct.getCompareCart().getOwnerId())
                .orElseThrow(()->new NoSuchElementException(""));
        searchedCart.removeProduct(cartProduct);

        return ResponseEntity.ok().build();
    }



    private boolean isDupId(String ownerId){
        return compareCartRepository.findByOwnerId(ownerId).isPresent();
    }
}
