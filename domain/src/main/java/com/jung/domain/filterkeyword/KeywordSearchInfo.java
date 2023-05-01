package com.jung.domain.filterkeyword;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KeywordSearchInfo {
    @NotNull
    private String searchKeyword;
    @NotNull
    private String ownerId;
}
