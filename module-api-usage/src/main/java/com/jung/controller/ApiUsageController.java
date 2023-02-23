package com.jung.controller;

import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.service.ApiUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiUsageController {

    private final ApiUsageService apiUsageService;

    @GetMapping("/current-usage")
    public ResponseEntity<?> getCurrentUsage(){
        return apiUsageService.getUsage();
    }

    @GetMapping("/max-usage")
    public ResponseEntity<?> getMaxUsage(){
        return apiUsageService.getMaxUsage();
    }

    @PostMapping("/api")
    public ResponseEntity<?> addApi(@RequestBody ApiUsageDTO apiUsageDTO){
        return apiUsageService.addApi(apiUsageDTO);
    }

    @PostMapping("/usage")
    public ResponseEntity<?> increaseUsage(){
        return apiUsageService.increaseUsage();
    }

//    @PostMapping("/usage-zero")
//    public ResponseEntity<?> initUsage(){
//
//    }
}
