package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeyword;
import com.jung.domain.filterkeyword.FilterKeywordRepository;
import com.jung.domain.filterkeyword.KeywordSearchInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilterKeywordService {
    private final FilterKeywordRepository filterKeywordRepository;

    public ResponseEntity<?> generateFilterKeyword(){

    }

    public ResponseEntity<?> deleteFilterKeyword(){

    }

    public ResponseEntity<?> searchFilterKeyword(KeywordSearchInfo keywordSearchInfo){
        List<FilterKeyword> keywordList = filterKeywordRepository.findByOwnerId(keywordSearchInfo.getOwnerId());

    }

    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(){

    }

    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }
}
