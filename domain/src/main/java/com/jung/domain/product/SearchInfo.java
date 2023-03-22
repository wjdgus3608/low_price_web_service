package com.jung.domain.product;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Embeddable
public class SearchInfo {
    @NotNull
    private String query;
    private int display;
    private int start;
    @Enumerated(EnumType.STRING)
    private SortType sort;
    private String filter;
    private String exclude;
}
