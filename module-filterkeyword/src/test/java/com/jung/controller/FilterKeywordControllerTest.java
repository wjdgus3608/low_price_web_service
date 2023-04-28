package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class FilterKeywordControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    @DisplayName("필터키워드 컨트롤러 테스트 초기 설정")
    void initKeyword() throws Exception {
        
    }

    @Test
    void searchKeywordByInfo() {
    }

    @Test
    void generateFilterKeyword() {
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