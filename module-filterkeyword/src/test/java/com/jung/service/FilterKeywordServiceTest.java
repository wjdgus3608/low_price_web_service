package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeyword;
import com.jung.domain.filterkeyword.KeywordSearchInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class FilterKeywordServiceTest {
    @Autowired
    private FilterKeywordService filterKeywordService;

    private KeywordSearchInfo keywordSearchInfo;

    @BeforeAll
    void setFilterKeyword(){
        keywordSearchInfo = KeywordSearchInfo.builder()
                .searchKeyword("keyword1")
                .ownerId("user1")
                .build();
//        filterKeywordService.generateFilterKeyword("user1");
    }

    @Test
    @DisplayName("필터키워드 검색")
    void searchFilterKeyword(){
        //given
        //when
        Optional<FilterKeyword> findKeyword = filterKeywordService.searchKeywordByInfo(keywordSearchInfo);
        //then
        assertTrue(findKeyword.isPresent());
        assertEquals("user1",findKeyword.get().getOwnerId());
        assertEquals("keyword1",findKeyword.get().getSearchKeyword());
    }

    @Test
    @DisplayName("필터키워드 생성")
    void generateFilterKeyword() {
        //given
        //when
        filterKeywordService.generateFilterKeyword(keywordSearchInfo);
        //then
    }

    @Test
    void deleteFilterKeyword() {
    }

    @Test
    void addExcludeKeywordToFilterKeyword() {
    }

    @Test
    void removeExcludeKeywordFromFilterKeyword() {
    }
}