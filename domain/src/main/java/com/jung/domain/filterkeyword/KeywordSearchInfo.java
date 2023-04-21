package com.jung.domain.filterkeyword;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class KeywordSearchInfo {
    @NotNull
    private final String searchKeyword;
    private final String ownerId;
}
