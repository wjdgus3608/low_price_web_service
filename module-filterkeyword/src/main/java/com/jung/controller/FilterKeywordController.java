package com.jung.controller;

import com.jung.domain.filterkeyword.*;
import com.jung.service.FilterKeywordService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FilterKeywordController {
    private final FilterKeywordService filterKeywordService;

    @GetMapping("/filter-keywords/{ownerId}")
    public ResponseEntity<?> searchKeywordByOwnerId(@PathVariable String ownerId){
        return ResponseEntity.ok(filterKeywordService.searchKeywordByOwnerId(ownerId));
    }
    @PostMapping("/filter-keyword")
    public ResponseEntity<?> generateFilterKeyword(@RequestBody FilterKeywordDTO keywordDTO){
        return filterKeywordService.generateFilterKeyword(keywordDTO);
    }

    @DeleteMapping("/filter-keyword")
    public ResponseEntity<?> deleteFilterKeyword(@RequestBody @Valid FilterKeywordDTO filterKeywordDTO){
        return filterKeywordService.deleteFilterKeyword(filterKeywordDTO);
    }

    @GetMapping("/filter-keyword/{ownerId}/{keyword}")
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
    public ResponseEntity<?> removeExcludeKeywordFromFilterKeyword(@RequestBody ExcludeKeywordDTO excludeKeywordDTO){
        return filterKeywordService.removeExcludeKeywordFromFilterKeyword(excludeKeywordDTO);
    }

    @GetMapping("/filter-keyword/{ownerId}/{searchKeyword}/exclude-keyword/{excludeKeyword}")
    public ResponseEntity<?> searchExcludeKeyword(@PathVariable String ownerId,
                                                  @PathVariable String searchKeyword,
                                                  @PathVariable String excludeKeyword){

        KeywordSearchInfo searchInfo = KeywordUtil.generateKeywordSearchInfo(ownerId, searchKeyword);
        ExcludeKeywordDTO excludeKeywordDTO = KeywordUtil.generateExcludeKeywordDTO(excludeKeyword,searchInfo);
        Optional<ExcludeKeyword> searchedKeyword = filterKeywordService.searchExcludeKeyword(excludeKeywordDTO);
        if(searchedKeyword.isEmpty())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(searchedKeyword);
    }

    @Generated
    private ExcludeKeywordDTO parseHeaderToExcludeKeyword(HttpHeaders headers){
        KeywordSearchInfo keywordSearchInfo = KeywordSearchInfo.builder()
                .ownerId(Objects.requireNonNull(headers.get("ownerId")).get(0))
                .searchKeyword(Objects.requireNonNull(headers.get("searchKeyword")).get(0))
                .build();

        return ExcludeKeywordDTO.builder()
                .excludeKeyword(Objects.requireNonNull(headers.get("excludeKeyword")).get(0))
                .keywordSearchInfo(keywordSearchInfo)
                .build();
    }
}
