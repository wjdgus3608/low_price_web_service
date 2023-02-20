package com.jung.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUsageController {
    @GetMapping("/current-usage")
    public ResponseEntity<?> getCurrentUsage(){

    }

    @GetMapping("/max-usage")
    public ResponseEntity<?> getMaxUsage(){

    }

    @PostMapping("/api")
    public ResponseEntity<?> addApi(){

    }

    @PostMapping("/usage")
    public ResponseEntity<?> increaseUsage(){

    }

    @PostMapping("/usage-zero")
    public ResponseEntity<?> initUsage(){

    }
}
