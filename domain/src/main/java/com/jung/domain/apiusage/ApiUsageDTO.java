package com.jung.domain.apiusage;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiUsageDTO {
    int responseCode;
    String responseMessage;
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
