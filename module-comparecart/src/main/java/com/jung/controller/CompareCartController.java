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
    public ResponseEntity<?> removeCart(@RequestBody String ownerId){
        return compareCartService.removeCart(ownerId);
    }

    @GetMapping("/compare-cart/{ownerId}")
    public ResponseEntity<?> searchCart(@PathVariable String ownerId){
        return ResponseEntity.ok(compareCartService.searchCart(ownerId));
    }

    @DeleteMapping("/cart-products")
    public ResponseEntity<?> clearCart(@RequestHeader HttpHeaders headers){
        return compareCartService.clearCart(Objects.requireNonNull(headers.get("ownerId")).get(0));
    }

    @PostMapping("/cart-product")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid CartProductDTO cartProductDTO){
        return compareCartService.addProductToCart(cartProductDTO);
    }

    @DeleteMapping("/cart-product")
    public ResponseEntity<?> removeProductFromCart(@RequestBody @Valid CartProductDTO cartProductDTO){
        return compareCartService.removeProductFromCart(cartProductDTO);
    }
}
