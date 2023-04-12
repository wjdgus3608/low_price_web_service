package com.jung.domain.apiusage;

import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiUsageDTO {
    private int responseCode;
    private String responseMessage;
    @NotNull
    private ApiType apiType;
    @NotNull
    private long currentUsage;
    @NotNull
    private long maxUsage;

    public ApiUsage dtoToEntity(ApiUsageDTO apiUsageDTO){
        return ApiUsage.builder()
                .apiType(apiUsageDTO.getApiType())
                .currentUsage(apiUsageDTO.getCurrentUsage())
                .maxUsage(apiUsageDTO.getMaxUsage())
                .build();
    }

}
