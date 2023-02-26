package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsage;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.apiusage.ApiUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiUsageService {
    private final ApiUsageRepository apiUsageRepository;

    @Cacheable(value = "ApiUsage")
    public ApiUsage getApiInfo(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        return apiUsages.get(0);
    }


    @Transactional
    @CacheEvict(value = "ApiUsage")
    public ResponseEntity<?> addApi(ApiUsageDTO apiUsageDTO){
        apiUsageRepository.save(apiUsageDTO.dtoToEntity(apiUsageDTO));
        return ResponseEntity.ok().build();
    }

    @Transactional
    @CacheEvict(value = "ApiUsage")
    public ResponseEntity<?> increaseUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).increaseUsage();

        return ResponseEntity.ok().build();
    }

    @Transactional
    @CacheEvict(value = "ApiUsage")
    public ResponseEntity<?> initUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).initUsage();

        return ResponseEntity.ok().build();
    }
}
