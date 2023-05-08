package com.jung.service;

import com.jung.domain.filterkeyword.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ExcludeKeywordDTO excludeKeywordDTO;
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
        excludeKeywordDTO = ExcludeKeywordDTO.builder()
                .keywordSearchInfo(keywordSearchInfo)
                .excludeKeyword("excludeKeyword1")
                .build();
        filterKeywordService.addExcludeKeywordToFilterKeyword(excludeKeywordDTO);
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
    @DisplayName("필터키워드 생성(중복실패)")
    void generateFilterKeywordWithDup() {
        //given
        //when
        ResponseEntity<?> response = filterKeywordService.generateFilterKeyword(baseDTO);
        //then
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
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
    @DisplayName("제외키워드 검색")
    void searchExcludeKeyword(){
        //given

        //when
        Optional<ExcludeKeyword> excludeKeyword = filterKeywordService.searchExcludeKeyword(excludeKeywordDTO);
        //then
        assertTrue(excludeKeyword.isPresent());
        assertEquals(excludeKeywordDTO.getExcludeKeyword(),excludeKeyword.get().getKeyword());
    }

    @Test
    @DisplayName("제외키워드 추가")
    void addExcludeKeywordToFilterKeyword() {
        //given
        ExcludeKeywordDTO dto = ExcludeKeywordDTO.builder()
                .keywordSearchInfo(keywordSearchInfo)
                .excludeKeyword("excludeKeyword2")
                .build();
        //when
        ResponseEntity<?> responseEntity = filterKeywordService.addExcludeKeywordToFilterKeyword(dto);
        Optional<ExcludeKeyword> excludeKeyword = filterKeywordService.searchExcludeKeyword(dto);
        //then
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertTrue(excludeKeyword.isPresent());
        assertEquals(dto.getExcludeKeyword(),excludeKeyword.get().getKeyword());
    }

    @Test
    @DisplayName("제외키워드 추가(중복실패)")
    void addExcludeKeywordToFilterKeywordWithDup() {
        //given
        //when
        ResponseEntity<?> responseEntity = filterKeywordService.addExcludeKeywordToFilterKeyword(excludeKeywordDTO);
        //then
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("제외키워드 삭제")
    void removeExcludeKeywordFromFilterKeyword() {
        //given
        //when
        ResponseEntity<?> responseEntity = filterKeywordService.removeExcludeKeywordFromFilterKeyword(excludeKeywordDTO);
        Optional<ExcludeKeyword> excludeKeyword = filterKeywordService.searchExcludeKeyword(excludeKeywordDTO);
        //then
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertFalse(excludeKeyword.isPresent());
    }
}