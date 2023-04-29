package com.jung.domain.filterkeyword;

public class KeywordUtil {
    public static FilterKeywordDTO generateFilterKeywordDTO(String ownerId, String searchKeyword){
        return FilterKeywordDTO.builder()
                .ownerId(ownerId)
                .searchKeyword(searchKeyword)
                .build();
    }

    public static ExcludeKeywordDTO generateExcludeKeywordDTO(String keyword, KeywordSearchInfo searchInfo){
        return ExcludeKeywordDTO.builder()
                .excludeKeyword(keyword)
                .keywordSearchInfo(searchInfo)
                .build();
    }
}
