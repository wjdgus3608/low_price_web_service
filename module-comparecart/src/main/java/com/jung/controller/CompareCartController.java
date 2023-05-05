package com.jung.controller;

import com.jung.domain.comparecart.CartProductDTO;
import com.jung.domain.comparecart.CartUtil;
import com.jung.service.CompareCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CompareCartController {

    private final CompareCartService compareCartService;

    @PostMapping("/compare-cart")
    public ResponseEntity<?> generateCart(@RequestBody String ownerId){
        return compareCartService.generateCart(ownerId);
    }

    @DeleteMapping("/compare-cart")
    public ResponseEntity<?> removeCart(@RequestHeader HttpHeaders headers){
        return compareCartService.removeCart(Objects.requireNonNull(headers.get("ownerId")).get(0));
    }

    @GetMapping("/compare-cart/{ownerId}")
    public ResponseEntity<?> searchCart(@PathVariable String ownerId){
        return ResponseEntity.ok(compareCartService.searchCart(ownerId));
    }

    @DeleteMapping("/compare-cart/{ownerId}/cart-products")
    public ResponseEntity<?> clearCart(@PathVariable String ownerId){
        return compareCartService.clearCart(ownerId);
    }

    @PostMapping("/cart-product")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid CartProductDTO cartProductDTO){
        return compareCartService.addProductToCart(cartProductDTO);
    }

    @DeleteMapping("/cart-product/{ownerId}/{productId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable String ownerId, @PathVariable long productId){
        return compareCartService.removeProductFromCart(CartProductDTO.builder()
                .ownerId(ownerId)
                .productId(productId)
                .build());
    }
}
