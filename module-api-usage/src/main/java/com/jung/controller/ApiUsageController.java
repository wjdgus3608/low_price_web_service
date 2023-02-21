package com.jung.controller;

import com.jung.service.ApiUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiUsageController {

    private final ApiUsageService apiUsageService;

    @GetMapping("/current-usage")
    public ResponseEntity<?> getCurrentUsage(){
        return apiUsageService.getUsage();
    }

//    @GetMapping("/max-usage")
//    public ResponseEntity<?> getMaxUsage(){
//
//    }
//
//    @PostMapping("/api")
//    public ResponseEntity<?> addApi(){
//
//    }
//
//    @PostMapping("/usage")
//    public ResponseEntity<?> increaseUsage(){
//
//    }
//
//    @PostMapping("/usage-zero")
//    public ResponseEntity<?> initUsage(){
//
//    }
}
