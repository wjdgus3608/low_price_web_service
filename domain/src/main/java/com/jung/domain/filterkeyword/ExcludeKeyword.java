package com.jung.domain.filterkeyword;

import com.jung.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ExcludeKeyword extends BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String keyword;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_keyword_id")
    private FilterKeyword filterKeyword;

    public void connectFilterKeyword(FilterKeyword filterKeyword){
        this.filterKeyword=filterKeyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcludeKeyword that = (ExcludeKeyword) o;
        return keyword.equals(that.keyword) && filterKeyword.equals(that.filterKeyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword, filterKeyword);
    }
}
