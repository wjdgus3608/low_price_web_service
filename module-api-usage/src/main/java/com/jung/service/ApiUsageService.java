package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsage;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.apiusage.ApiUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiUsageService {
    private final ApiUsageRepository apiUsageRepository;

    public ResponseEntity<?> getApiInfo(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .responseCode(0)
                .responseMessage("정상")
                .apiType(ApiType.SHOPPING_API)
                .currentUsage(apiUsages.get(0).getCurrentUsage())
                .maxUsage(apiUsages.get(0).getMaxUsage())
                .build();
        return ResponseEntity.ok(apiUsageDTO);
    }


    @Transactional
    public ResponseEntity<?> addApi(ApiUsageDTO apiUsageDTO){
        apiUsageRepository.save(apiUsageDTO.dtoToEntity(apiUsageDTO));
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> increaseUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).increaseUsage();

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> initUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).initUsage();

        return ResponseEntity.ok().build();
    }
}
