package com.jung.service;

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

    public ResponseEntity<?> clearCart(){

    }

    public ResponseEntity<?> searchCart(){

    }

    public ResponseEntity<?> addProductToCart(){

    }

    public ResponseEntity<?> removeProductFromCart(){

    }
}
