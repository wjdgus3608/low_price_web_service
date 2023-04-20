package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilterKeywordService {
    private final FilterKeywordRepository filterKeywordRepository;

    public ResponseEntity<?> generateFilterKeyword(){

    }

    public ResponseEntity<?> deleteFilterKeyword(){

    }

    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(){

    }

    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }
}
