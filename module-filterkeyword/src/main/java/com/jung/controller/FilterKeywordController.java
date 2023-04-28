package com.jung.controller;

import com.jung.service.FilterKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FilterKeywordController {
    private final FilterKeywordService filterKeywordService;

    /*public ResponseEntity<?> searchKeywordByInfo(){

    }
    public ResponseEntity<?> generateFilterKeyword(){

    }
    public ResponseEntity<?> deleteFilterKeyword(){

    }
    public ResponseEntity<?> searchExcludeKeyword(){

    }
    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(){

    }
    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }*/
}
