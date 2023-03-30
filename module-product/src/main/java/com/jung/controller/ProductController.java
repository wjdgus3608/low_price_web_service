package com.jung.controller;

import com.jung.domain.product.SearchInfo;
import com.jung.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> searchProducts(SearchInfo searchInfo){
        return ResponseEntity.ok(productService.searchProduct(searchInfo));
    }
}
