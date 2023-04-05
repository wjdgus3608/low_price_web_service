package com.jung.controller;

import com.jung.service.CompareCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompareCartController {

    private final CompareCartService compareCartService;

/*    public ResponseEntity<?> generateCart(){

    }

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
