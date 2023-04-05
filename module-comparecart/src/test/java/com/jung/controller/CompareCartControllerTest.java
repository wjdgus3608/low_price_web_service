package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
class CompareCartControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("비교카트 생성")
    void generateCart() {
    }

    @Test
    @DisplayName("비교카트 삭제")
    void removeCart() {
    }

    @Test
    @DisplayName("비교카트 검색")
    void searchCart() {
    }

    @Test
    @DisplayName("비교카트 비우기")
    void clearCart() {
    }

    @Test
    @DisplayName("비교카트 상품추가")
    void addProductToCart() {
    }

    @Test
    @DisplayName("비교카트 상품제거")
    void removeProductFromCart() {
    }
}