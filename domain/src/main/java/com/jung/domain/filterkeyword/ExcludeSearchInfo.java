package com.jung.domain.filterkeyword;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class ExcludeSearchInfo {
    @NotNull
    private final String keyword;
    @NotNull
    private final String ownerId;
}
