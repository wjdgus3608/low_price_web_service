package com.jung.controller;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.service.ApiUsageService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = ApiUsageController.class)
class ApiUsageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ApiUsageService apiUsageService;

    @BeforeAll
    void addTestApi(){
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .apiType(ApiType.SHOPPING_API)
                .apiUsage(0)
                .maxUsage(25000)
                .build();
        apiUsageService.addApi(apiUsageDTO);
    }

    @Test
    void getCurrentUsage() throws Exception {
        //given
//        apiUsageService.
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/current-usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.currentUsage", Matchers.notNullValue()));
    }

    @Test
    void getMaxUsage() {
    }

    @Test
    void addApi() {
    }

    @Test
    void increaseUsage() {
    }

    @Test
    void initUsage() {
    }
}