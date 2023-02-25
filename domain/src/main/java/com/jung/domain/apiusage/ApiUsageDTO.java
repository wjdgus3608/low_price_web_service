package com.jung.domain.apiusage;

import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiUsageDTO {
    int responseCode;
    String responseMessage;
    @NotNull
    ApiType apiType;
    @NotNull
    long currentUsage;
    @NotNull
    long maxUsage;

    public ApiUsage dtoToEntity(ApiUsageDTO apiUsageDTO){
        return ApiUsage.builder()
                .apiType(apiUsageDTO.getApiType())
                .currentUsage(apiUsageDTO.getCurrentUsage())
                .maxUsage(apiUsageDTO.getMaxUsage())
                .build();
    }

}
