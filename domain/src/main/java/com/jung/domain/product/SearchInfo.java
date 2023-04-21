package com.jung.domain.product;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Builder
@Getter
public class SearchInfo {
    @NotNull
    private final String query;
    private final int display;
    private final int start;
    @Enumerated(EnumType.STRING)
    private final SortType sort;
    private final String filter;
    private final String exclude;
}
