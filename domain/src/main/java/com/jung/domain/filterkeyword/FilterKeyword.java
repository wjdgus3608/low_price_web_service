package com.jung.domain.filterkeyword;

import com.jung.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class FilterKeyword extends BaseEntity {
    @Id
    @GeneratedValue
    private long filterKeywordId;
    @Column(nullable = false)
    private String searchKeyword;
    @Column(nullable = false)
    private String ownerId;
    @OneToMany(mappedBy = "filterKeyword")
    List<ExcludeKeyword> keywordList = new ArrayList<>();
    @ColumnDefault("0")
    private long totalCnt;
}
