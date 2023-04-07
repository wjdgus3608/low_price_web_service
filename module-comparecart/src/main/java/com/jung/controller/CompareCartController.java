package com.jung.controller;

import com.jung.service.CompareCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompareCartController {

    private final CompareCartService compareCartService;

    @PostMapping("/compare-cart")
    public ResponseEntity<?> generateCart(@RequestBody String ownerId){
        return compareCartService.generateCart(ownerId);
    }
/*
    public ResponseEntity<?> removeCart(){

    }

    public ResponseEntity<?> searchCart(){

    }

    public ResponseEntity<?> clearCart(){

    }
    public ResponseEntity<?> addProductToCart(){

    }
    public ResponseEntity<?> removeProductFromCart(){

    }*/
}
