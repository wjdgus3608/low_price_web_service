package com.jung.domain.filterkeyword;

import com.jung.domain.RequestDTO;
import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilterKeywordDTO implements RequestDTO<FilterKeyword> {

    @NotNull
    private String searchKeyword;
    @NotNull
    private String ownerId;

    @Override
    public FilterKeyword toEntity() {
        return FilterKeyword.builder()
                .searchKeyword(this.searchKeyword)
                .ownerId(this.ownerId)
                .build();
    }
}
