package com.jung.domain.filterkeyword;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class ExcludeKeywordDTO {
    @NotNull
    private final KeywordSearchInfo keywordSearchInfo;
    @NotNull
    private final String excludeKeyword;

}
