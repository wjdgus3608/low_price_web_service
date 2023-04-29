package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.filterkeyword.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class FilterKeywordControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private FilterKeywordDTO filterKeywordDTO;
    private KeywordSearchInfo keywordSearchInfo;
    private ExcludeKeywordDTO excludeKeywordDTO;

    @BeforeAll
    @DisplayName("필터키워드 컨트롤러 테스트 초기 설정")
    void initKeyword() throws Exception {
        filterKeywordDTO = KeywordUtil.generateFilterKeywordDTO("user1","keyword1");
        keywordSearchInfo = KeywordUtil.generateKeywordSearchInfo("user1","keyword1");
        excludeKeywordDTO = KeywordUtil.generateExcludeKeywordDTO("excludekeyword1",keywordSearchInfo);
    }

    @Test
    void searchKeywordByInfo() {

    }

    @Test
    @DisplayName("필터키워드 생성")
    void generateFilterKeyword() throws Exception {
        //given
        //when
        String dto = objectMapper.writeValueAsString(filterKeywordDTO);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/filterkeyword")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void deleteFilterKeyword() {

    }

    @Test
    void searchExcludeKeyword() {

    }

    @Test
    void addExcludeKeywordToFilterKeyword() {

    }

    @Test
    void removeExcludeKeywordFromFilterKeyword() {

    }


}