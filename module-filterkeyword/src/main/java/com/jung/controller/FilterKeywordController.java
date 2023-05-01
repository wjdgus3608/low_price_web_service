package com.jung.controller;

import com.jung.domain.filterkeyword.FilterKeyword;
import com.jung.domain.filterkeyword.FilterKeywordDTO;
import com.jung.domain.filterkeyword.KeywordSearchInfo;
import com.jung.domain.filterkeyword.KeywordUtil;
import com.jung.service.FilterKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FilterKeywordController {
    private final FilterKeywordService filterKeywordService;

    @PostMapping("/filterkeyword")
    public ResponseEntity<?> generateFilterKeyword(@RequestBody FilterKeywordDTO keywordDTO){
        return filterKeywordService.generateFilterKeyword(keywordDTO);
    }

    @DeleteMapping("/filterkeyword/{ownerId}/{keyword}")
    public ResponseEntity<?> deleteFilterKeyword(@PathVariable String ownerId, @PathVariable String keyword){
        FilterKeywordDTO filterKeywordDTO = KeywordUtil.generateFilterKeywordDTO(ownerId, keyword);
        return filterKeywordService.deleteFilterKeyword(filterKeywordDTO);
    }

    @GetMapping("/filterkeyword/{ownerId}/{keyword}")
    public ResponseEntity<?> searchKeywordByInfo(@PathVariable String ownerId, @PathVariable String keyword){
        KeywordSearchInfo searchInfo = KeywordUtil.generateFilterKeywordDTO(ownerId, keyword).toSearchInfo();
        Optional<FilterKeyword> filterKeyword = filterKeywordService.searchKeywordByInfo(searchInfo);
        if(filterKeyword.isEmpty())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(filterKeyword);
    }
    /*


    public ResponseEntity<?> searchExcludeKeyword(){

    }
    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(){

    }
    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(){

    }*/
}
