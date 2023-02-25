package com.jung.controller;

import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.service.ApiUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ApiUsageController {

    private final ApiUsageService apiUsageService;

    @GetMapping("/api")
    public ResponseEntity<?> getApiInfo(){
        return apiUsageService.getApiInfo();
    }

    @PostMapping("/api")
    public ResponseEntity<?> addApi(@RequestBody @Valid ApiUsageDTO apiUsageDTO){
        return apiUsageService.addApi(apiUsageDTO);
    }

    @PostMapping("/usage")
    public ResponseEntity<?> increaseUsage(){
        return apiUsageService.increaseUsage();
    }

    @PostMapping("/usage-zero")
    public ResponseEntity<?> initUsage(){
        return apiUsageService.initUsage();
    }
}
