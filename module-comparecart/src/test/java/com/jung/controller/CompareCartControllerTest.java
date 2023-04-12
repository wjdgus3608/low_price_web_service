package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.comparecart.AddCartProductDTO;
import com.jung.domain.comparecart.CartProduct;
import com.jung.domain.comparecart.CartUtil;
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
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
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

        mockMvc.perform(MockMvcRequestBuilders.post("/compare-cart")
                .content(firstCompareCart.getOwnerId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 생성")
    void generateCart() throws Exception {
        //given
        CompareCart secondCart = CompareCart.builder()
                .ownerId("user2")
                .build();
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/compare-cart")
                .content(secondCart.getOwnerId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 삭제")
    @Transactional
    void removeCart() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/compare-cart")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("ownerId",firstCompareCart.getOwnerId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 검색")
    void searchCart() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/compare-cart")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("ownerId",firstCompareCart.getOwnerId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("ownerId")
                        .value(equalTo(firstCompareCart.getOwnerId())))
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 비우기")
    void clearCart() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/cart-products")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("ownerId",firstCompareCart.getOwnerId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 상품추가")
    void addProductToCart() throws Exception {
        //given
        AddCartProductDTO dto = AddCartProductDTO.builder()
                                .ownerId("user1")
                                .productId(1L)
                                .build();
        //when
        String strEntity = objectMapper.writeValueAsString(dto);
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/cart-products")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(strEntity))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("비교카트 상품제거")
    void removeProductFromCart() {
    }
}