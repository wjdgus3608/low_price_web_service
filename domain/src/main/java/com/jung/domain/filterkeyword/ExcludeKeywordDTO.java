package com.jung.domain.filterkeyword;

import com.jung.domain.BaseDTO;
import com.jung.domain.RequestDTO;
import com.jung.domain.comparecart.CartProduct;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class ExcludeKeywordDTO implements RequestDTO<ExcludeKeyword> {
    @NotNull
    private final KeywordSearchInfo keywordSearchInfo;
    @NotNull
    private final String excludeKeyword;

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
