package com.jung.service;

import com.jung.domain.filterkeyword.FilterKeyword;
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

    private Search

    @BeforeAll
    void setFilterKeyword(){
//        filterKeywordService.generateFilterKeyword("user1");
    }

    @Test
    @DisplayName("필터키워드 검색")
    void searchFilterKeyword(){
        //given
        //when
        Optional<FilterKeyword> findKeyword = filterKeywordService.searchFilterKeyword(searchInfo);
        //then
        assertTrue(findKeyword.isPresent());
        assertEquals("user1",findKeyword.get().getOwnerId());
        assertEquals("keyword1",findKeyword.get().getSearchKeyword());
    }

    @Test
    void generateFilterKeyword() {
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