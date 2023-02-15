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

}
