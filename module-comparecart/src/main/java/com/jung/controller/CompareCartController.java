package com.jung.controller;

import com.jung.domain.comparecart.CartProductDTO;
import com.jung.domain.comparecart.CartUtil;
import com.jung.service.CompareCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CompareCartController {

    private final CompareCartService compareCartService;

    @PostMapping("/compare-cart")
    public ResponseEntity<?> generateCart(@RequestBody String ownerId){
        return compareCartService.generateCart(ownerId);
    }

    @DeleteMapping("/compare-cart")
    public ResponseEntity<?> removeCart(@RequestHeader("ownerId") String ownerId){
        return compareCartService.removeCart(ownerId);
    }

    @GetMapping("/compare-cart")
    public ResponseEntity<?> searchCart(@RequestHeader("ownerId") String ownerId){
        return ResponseEntity.ok(compareCartService.searchCart(ownerId));
    }

    @DeleteMapping("/cart-products")
    public ResponseEntity<?> clearCart(@RequestHeader("ownerId") String ownerId){
        return compareCartService.clearCart(ownerId);
    }

    @PostMapping("/cart-product")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid CartProductDTO cartProductDTO){
        return compareCartService.addProductToCart(cartProductDTO);
    }

    @DeleteMapping("/cart-product/{ownerId}/{productId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable String ownerId, @PathVariable String productId){
        return compareCartService.removeProductFromCart(CartProductDTO.builder()
                .ownerId(ownerId)
                .productId(Long.parseLong(productId))
                .build());
    }
}
