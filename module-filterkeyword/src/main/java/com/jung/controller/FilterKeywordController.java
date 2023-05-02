package com.jung.controller;

import com.jung.domain.filterkeyword.*;
import com.jung.service.FilterKeywordService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FilterKeywordController {
    private final FilterKeywordService filterKeywordService;

    @PostMapping("/filter-keyword")
    public ResponseEntity<?> generateFilterKeyword(@RequestBody FilterKeywordDTO keywordDTO){
        return filterKeywordService.generateFilterKeyword(keywordDTO);
    }

    @DeleteMapping("/filter-keyword/{ownerId}/exclude-keyword/{keyword}")
    public ResponseEntity<?> deleteFilterKeyword(@PathVariable String ownerId, @PathVariable String keyword){
        FilterKeywordDTO filterKeywordDTO = KeywordUtil.generateFilterKeywordDTO(ownerId, keyword);
        return filterKeywordService.deleteFilterKeyword(filterKeywordDTO);
    }

    @GetMapping("/filter-keyword/{ownerId}/exclude-keyword/{keyword}")
    public ResponseEntity<?> searchKeywordByInfo(@PathVariable String ownerId, @PathVariable String keyword){
        KeywordSearchInfo searchInfo = KeywordUtil.generateFilterKeywordDTO(ownerId, keyword).toSearchInfo();
        Optional<FilterKeyword> filterKeyword = filterKeywordService.searchKeywordByInfo(searchInfo);
        if(filterKeyword.isEmpty())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(filterKeyword);
    }

    @PostMapping("/exclude-keyword")
    public ResponseEntity<?> addExcludeKeywordToFilterKeyword(@RequestBody ExcludeKeywordDTO excludeKeywordDTO){
        return filterKeywordService.addExcludeKeywordToFilterKeyword(excludeKeywordDTO);
    }

    @DeleteMapping("/exclude-keyword")
    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(@RequestHeader HttpHeaders headers){
        ExcludeKeywordDTO excludeKeywordDTO = parseHeaderToExcludeKeyword(headers);
        return filterKeywordService.removeExcludeKeywordFromFilterKeyword(excludeKeywordDTO);
    }

    /*


    public ResponseEntity<?> searchExcludeKeyword(){

    }

    */

    private ExcludeKeywordDTO parseHeaderToExcludeKeyword(HttpHeaders headers){
        KeywordSearchInfo keywordSearchInfo = KeywordSearchInfo.builder()
                .ownerId(headers.get("ownerId").get(0))
                .searchKeyword(headers.get("searchKeyword").get(0))
                .build();

        return ExcludeKeywordDTO.builder()
                .excludeKeyword(headers.get("excludeKeyword").get(0))
                .keywordSearchInfo(keywordSearchInfo)
                .build();
    }
}
