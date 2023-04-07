package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.comparecart.CompareCart;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
class CompareCartControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private CompareCart firstCompareCart;

    @BeforeAll
    @DisplayName("비교카트 테스트 초기 설정")
    void initCart() throws Exception {
        firstCompareCart = CompareCart.builder()
                .ownerId("user1")
                .build();
        String strEntity = objectMapper.writeValueAsString(firstCompareCart);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/compare-cart")
                .content(strEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

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