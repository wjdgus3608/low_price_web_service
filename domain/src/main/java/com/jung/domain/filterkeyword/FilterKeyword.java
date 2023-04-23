package com.jung.domain.filterkeyword;

import com.jung.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;

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
    Map<String,ExcludeKeyword> keywordList = new HashMap<>();
    @ColumnDefault("0")
    private long totalCnt;

    public boolean addExcludeKeyword(ExcludeKeyword excludeKeyword){
        String key = excludeKeyword.getKeyword();
        if(keywordList.containsKey(key))
            return false;
        excludeKeyword.connectFilterKeyword(this);
        keywordList.put(key,excludeKeyword);
        return true;
    }

    public boolean removeExcludeKeyword(ExcludeKeyword excludeKeyword){
        String key = excludeKeyword.getKeyword();
        if(keywordList.containsKey(key))
            return false;
        keywordList.remove(key);
        totalCnt = keywordList.size();
        return true;
    }

    public void clearExcludeKeyword(){
        keywordList.clear();
        totalCnt = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterKeyword that = (FilterKeyword) o;
        return searchKeyword.equals(that.searchKeyword) && ownerId.equals(that.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchKeyword, ownerId);
    }
}
