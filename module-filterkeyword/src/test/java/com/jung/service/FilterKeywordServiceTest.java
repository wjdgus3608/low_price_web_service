package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeyword;
import com.jung.domain.filterkeyword.FilterKeywordDTO;
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
    private FilterKeywordDTO baseDTO;

    @BeforeAll
    void setFilterKeyword(){
        baseDTO = FilterKeywordDTO.builder()
                .searchKeyword("keyword1")
                .ownerId("user1")
                .build();
        filterKeywordService.generateFilterKeyword(baseDTO);
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
        FilterKeywordDTO dto = FilterKeywordDTO.builder()
                .searchKeyword("keyword2")
                .ownerId("user1")
                .build();
        //when
        filterKeywordService.generateFilterKeyword(dto);
        KeywordSearchInfo searchInfo = KeywordSearchInfo.builder()
                .searchKeyword("keyword2")
                .ownerId("user1")
                .build();
        Optional<FilterKeyword> findKeyword = filterKeywordService.searchKeywordByInfo(searchInfo);
        //then
        assertTrue(findKeyword.isPresent());
        assertEquals("user1",findKeyword.get().getOwnerId());
        assertEquals("keyword2",findKeyword.get().getSearchKeyword());
    }

    @Test
    @DisplayName("필터키워드 삭제")
    void deleteFilterKeyword() {
        //given
        //when
        filterKeywordService.deleteFilterKeyword(baseDTO);
        Optional<FilterKeyword> findKeyword = filterKeywordService.searchKeywordByInfo(keywordSearchInfo);
        //then
        assertFalse(findKeyword.isPresent());
    }

    @Test
    void addExcludeKeywordToFilterKeyword() {
    }

    @Test
    void removeExcludeKeywordFromFilterKeyword() {
    }
}