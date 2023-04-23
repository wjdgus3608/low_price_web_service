package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeyword;
import com.jung.domain.filterkeyword.FilterKeywordDTO;
import com.jung.domain.filterkeyword.FilterKeywordRepository;
import com.jung.domain.filterkeyword.KeywordSearchInfo;
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

    public Optional<FilterKeyword> searchKeywordByInfo(KeywordSearchInfo keywordSearchInfo){
        return filterKeywordRepository.findByOwnerIdAndSearchKeyword(
                keywordSearchInfo.getOwnerId(),
                keywordSearchInfo.getSearchKeyword());
    }

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


    public ResponseEntity<?> deleteFilterKeyword(FilterKeywordDTO filterKeywordDTO){
        KeywordSearchInfo searchInfo = filterKeywordDTO.toSearchInfo();
        FilterKeyword filterKeyword = searchKeywordByInfo(searchInfo).orElseThrow(()->new NoSuchElementException(""));

        filterKeywordRepository.delete(filterKeyword);
        return ResponseEntity.ok().build();
    }
    /*


    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(){

    }

    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }*/

    private boolean isDupKeyword(KeywordSearchInfo searchInfo){
        return searchKeywordByInfo(searchInfo).isPresent();
    }
}
