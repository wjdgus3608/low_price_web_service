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
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    void init() throws Exception {

    }
    @Test
    @DisplayName("상품조회 컨트롤러 테스트")
    void searchProducts() throws Exception {
        //given
        String queryString = buildQueryString();
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/product"+queryString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    private String buildQueryString(){
        String text = "삼겹살";
        StringBuilder sb = new StringBuilder();
        return sb.append("?query=")
                .append(text)
                .append("&display=100")
                .append("&start=1")
                .append("&sort=sim")
                .toString();
    }
}