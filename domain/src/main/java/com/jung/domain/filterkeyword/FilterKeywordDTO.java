package com.jung.domain.filterkeyword;

import com.jung.domain.RequestDTO;
import javax.validation.constraints.NotNull;
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

    public KeywordSearchInfo toSearchInfo(){
        return KeywordSearchInfo.builder()
                .ownerId(this.ownerId)
                .searchKeyword(this.searchKeyword)
                .build();
    }

    @Override
    public FilterKeyword toEntity() {
        return FilterKeyword.builder()
                .searchKeyword(this.searchKeyword)
                .ownerId(this.ownerId)
                .build();
    }
}
