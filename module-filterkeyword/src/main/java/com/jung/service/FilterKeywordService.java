package com.jung.service;

import com.jung.domain.filterkeyword.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilterKeywordService {
    private final FilterKeywordRepository filterKeywordRepository;

    public List<FilterKeyword> searchKeywordByOwnerId(String ownerId){
        return filterKeywordRepository.findByOwnerId(ownerId);
    }
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
        FilterKeyword filterKeyword = searchKeywordByInfo(keywordSearchInfo).orElseThrow(()->new NoSuchElementException(""));

        boolean isSuccess = filterKeyword.addExcludeKeyword(excludeKeywordDTO.toEntity());
        if (isSuccess)
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @Transactional
    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(ExcludeKeywordDTO excludeKeywordDTO){
        KeywordSearchInfo keywordSearchInfo = excludeKeywordDTO.getKeywordSearchInfo();
        FilterKeyword filterKeyword = searchKeywordByInfo(keywordSearchInfo).orElseThrow(()->new NoSuchElementException(""));

        boolean isSuccess = filterKeyword.removeExcludeKeyword(excludeKeywordDTO.toEntity());
        if (isSuccess)
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    private boolean isDupKeyword(KeywordSearchInfo searchInfo){
        return searchKeywordByInfo(searchInfo).isPresent();
    }
}
