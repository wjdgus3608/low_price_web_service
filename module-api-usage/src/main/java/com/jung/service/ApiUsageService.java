package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsage;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.apiusage.ApiUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiUsageService {
    private final ApiUsageRepository apiUsageRepository;

    public ApiUsageDTO getUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);

        return ApiUsageDTO.builder()
                .responseCode(300)
                .responseMessage("정상")
                .apiUsage(apiUsages.get(0).getCurrentUsage())
                .build();
    }

    public ApiUsageDTO getMaxUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);

        return ApiUsageDTO.builder()
                .responseMessage("정상")
                .apiUsage(apiUsages.get(0).getMaxUsage())
                .build();
    }

    @Transactional
    public ApiUsageDTO increaseUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).increaseUsage();

        return ApiUsageDTO.builder()
                .responseMessage("정상")
                .build();
    }

    @Transactional
    public ApiUsageDTO initUsage(){
        List<ApiUsage> apiUsages = apiUsageRepository.findByApiType(ApiType.SHOPPING_API);
        apiUsages.get(0).initUsage();

        return ApiUsageDTO.builder()
                .responseMessage("정상")
                .build();
    }
}
