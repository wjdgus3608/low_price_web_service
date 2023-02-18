package com.jung.domain.apiusage;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApiUsageDTO {
    int responseCode;
    String responseMessage;
    long apiUsage;
    ApiType apiType;
    long currentUsage;
    long maxUsage;

    public ApiUsage dtoToEntity(ApiUsageDTO apiUsageDTO){
        return ApiUsage.builder()
                .apiType(apiUsageDTO.getApiType())
                .currentUsage(apiUsageDTO.getCurrentUsage())
                .maxUsage(apiUsageDTO.getMaxUsage())
                .build();
    }

}
