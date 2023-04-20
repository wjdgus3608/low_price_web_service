package com.jung.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class FilterKeywordServiceTest {
    @Autowired
    private FilterKeywordService filterKeywordService;

    @BeforeAll
    void setFilterKeyword(){
//        filterKeywordService.generateFilterKeyword("user1");
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