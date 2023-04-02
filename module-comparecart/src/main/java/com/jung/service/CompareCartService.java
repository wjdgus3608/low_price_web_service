package com.jung.service;

import com.jung.domain.comparecart.CompareCart;
import com.jung.domain.comparecart.CompareCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompareCartService {
    private final CompareCartRepository compareCartRepository;

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
    /*


    public ResponseEntity<?> removeCart(){

    }

    public ResponseEntity<?> clearCart(){

    }

    public CompareCart searchCart(){

    }

    public ResponseEntity<?> addProductToCart(){

    }

    public ResponseEntity<?> removeProductFromCart(){

    }

     */

    private boolean isDupId(String ownerId){
        return compareCartRepository.findByOwnerId(ownerId)!=null;
    }
}
