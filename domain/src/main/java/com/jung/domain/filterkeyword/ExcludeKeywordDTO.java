package com.jung.domain.filterkeyword;

import com.jung.domain.BaseDTO;
import com.jung.domain.RequestDTO;
import com.jung.domain.comparecart.CartProduct;
import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcludeKeywordDTO implements RequestDTO<ExcludeKeyword> {
    @NotNull
    private KeywordSearchInfo keywordSearchInfo;
    @NotNull
    private String excludeKeyword;

    @Override
    public ExcludeKeyword toEntity() {

        FilterKeyword filterKeyword = FilterKeyword.builder()
                .ownerId(keywordSearchInfo.getOwnerId())
                .searchKeyword(keywordSearchInfo.getSearchKeyword())
                .build();

        return ExcludeKeyword.builder()
                .filterKeyword(filterKeyword)
                .keyword(this.excludeKeyword)
                .build();
    }
}
