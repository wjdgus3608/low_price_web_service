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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        excludeKeywordDTO = KeywordUtil.generateExcludeKeywordDTO("exclude-keyword1",keywordSearchInfo);

        String dto = objectMapper.writeValueAsString(filterKeywordDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/filter-keyword")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        String strDTO = objectMapper.writeValueAsString(excludeKeywordDTO);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/exclude-keyword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(strDTO)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }

    @Test
    void searchKeywordByInfo() {

    }

    @Test
    @DisplayName("필터키워드 생성")
    void generateFilterKeyword() throws Exception {
        //given
        FilterKeywordDTO dto = KeywordUtil.generateFilterKeywordDTO("user2", "keyword2");
        //when
        String strDTO = objectMapper.writeValueAsString(dto);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/filter-keyword")
                .content(strDTO)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("필터키워드 삭제")
    void deleteFilterKeyword() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/filter-keyword/"+filterKeywordDTO.getOwnerId()+"/exclude-keyword/"+filterKeywordDTO.getSearchKeyword())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("필터키워드 검색")
    void searchExcludeKeyword() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/filter-keyword/"+filterKeywordDTO.getOwnerId()+"/exclude-keyword/"+filterKeywordDTO.getSearchKeyword())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("제외키워드 추가")
    void addExcludeKeywordToFilterKeyword() throws Exception {
        //given
        ExcludeKeywordDTO dto = KeywordUtil.generateExcludeKeywordDTO("excludekeyword2", keywordSearchInfo);
        //when
        String strDTO = objectMapper.writeValueAsString(dto);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/exclude-keyword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(strDTO)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("제외키워드 삭제")
    void removeExcludeKeywordFromFilterKeyword() throws Exception {
        //given
        HttpHeaders headers = new HttpHeaders();
        headers.put("excludeKeyword", Collections.singletonList(excludeKeywordDTO.getExcludeKeyword()));
        headers.put("searchKeyword", Collections.singletonList(excludeKeywordDTO.getKeywordSearchInfo().getSearchKeyword()));
        headers.put("ownerId", Collections.singletonList(excludeKeywordDTO.getKeywordSearchInfo().getOwnerId()));
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/exclude-keyword")
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }


}