package com.jung.domain.filterkeyword;

import com.jung.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

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
}
