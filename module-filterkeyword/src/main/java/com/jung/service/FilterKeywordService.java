package com.jung.service;

import com.jung.domain.filterkeyword.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilterKeywordService {
    private final FilterKeywordRepository filterKeywordRepository;

    public Optional<FilterKeyword> searchKeywordByInfo(KeywordSearchInfo keywordSearchInfo){
        return filterKeywordRepository.findByOwnerIdAndSearchKeyword(
                keywordSearchInfo.getOwnerId(),
                keywordSearchInfo.getSearchKeyword());
    }

    @Transactional
    public ResponseEntity<?> generateFilterKeyword(FilterKeywordDTO keywordDTO){
        KeywordSearchInfo keywordSearchInfo = KeywordSearchInfo.builder()
                .searchKeyword(keywordDTO.getSearchKeyword())
                .ownerId(keywordDTO.getOwnerId())
                .build();

        if(isDupKeyword(keywordSearchInfo))
            return ResponseEntity.badRequest().build();

        filterKeywordRepository.save(keywordDTO.toEntity());
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteFilterKeyword(FilterKeywordDTO filterKeywordDTO){
        KeywordSearchInfo searchInfo = filterKeywordDTO.toSearchInfo();
        FilterKeyword filterKeyword = searchKeywordByInfo(searchInfo).orElseThrow(()->new NoSuchElementException(""));

        filterKeywordRepository.delete(filterKeyword);
        return ResponseEntity.ok().build();
    }

    public Optional<ExcludeKeyword> searchExcludeKeyword(ExcludeKeywordDTO excludeKeywordDTO){
        KeywordSearchInfo keywordSearchInfo = excludeKeywordDTO.getKeywordSearchInfo();
        Optional<FilterKeyword> filterKeyword = searchKeywordByInfo(keywordSearchInfo);

        return filterKeyword.map(keyword -> keyword.getKeywordList().get(excludeKeywordDTO.getExcludeKeyword()));
    }

    @Transactional
    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(ExcludeKeywordDTO excludeKeywordDTO){
        KeywordSearchInfo keywordSearchInfo = excludeKeywordDTO.getKeywordSearchInfo();
        Optional<FilterKeyword> filterKeyword = searchKeywordByInfo(keywordSearchInfo);
        filterKeyword.ifPresent(filterKeyword1 -> filterKeyword1.addExcludeKeyword(excludeKeywordDTO));

    }

    /*




    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }*/

    private boolean isDupKeyword(KeywordSearchInfo searchInfo){
        return searchKeywordByInfo(searchInfo).isPresent();
    }
}
