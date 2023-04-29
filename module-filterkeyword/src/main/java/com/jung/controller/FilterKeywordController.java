package com.jung.controller;

import com.jung.domain.filterkeyword.FilterKeywordDTO;
import com.jung.service.FilterKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FilterKeywordController {
    private final FilterKeywordService filterKeywordService;

    @PostMapping("/filterkeyword")
    public ResponseEntity<?> generateFilterKeyword(@RequestBody FilterKeywordDTO keywordDTO){
        return filterKeywordService.generateFilterKeyword(keywordDTO);
    }

    /*public ResponseEntity<?> searchKeywordByInfo(){

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
