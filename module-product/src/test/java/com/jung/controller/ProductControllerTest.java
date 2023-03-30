package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.product.ProductDTO;
import com.jung.domain.product.SearchInfo;
import com.jung.domain.product.SortType;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private SearchInfo searchInfo;
//    private int display;
//    private int start;
//    @Enumerated(EnumType.STRING)
//    private SortType sort;
//    private String filter;
//    private String exclude;
    @BeforeAll
    void init() throws Exception {

    }
    @Test
    @DisplayName("상품조회 컨트롤러 테스트")
    void searchProducts() throws Exception {
        //given
        String text = "삼겹살";
        try {
            text = URLEncoder.encode(searchInfo.getQuery(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/products/"+text+"/100/1/sim"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}