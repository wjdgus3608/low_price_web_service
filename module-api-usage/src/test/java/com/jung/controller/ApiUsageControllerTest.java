package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsageDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
class ApiUsageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private ResponseEntity<?> entity;

    ApiUsageControllerTest(){
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .apiType(ApiType.SHOPPING_API)
                .currentUsage(0)
                .maxUsage(25000)
                .build();
        this.entity = ResponseEntity.ok(apiUsageDTO);
    }

    @BeforeAll
    void addTestApi() throws Exception {

        String strEntity = objectMapper.writeValueAsString(entity.getBody());
        mockMvc.perform(MockMvcRequestBuilders.post("/api")
                    .content(strEntity)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }

    @Test
    @DisplayName("api 현재 사용량 조회")
    void getCurrentUsage() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/current-usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("currentUsage").value(equalTo(0)));
    }

    @Test
    @DisplayName("api 최대 사용량 조회")
    void getMaxUsage() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/max-usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("maxUsage").value(equalTo(25000)));
    }

    @Test
    @DisplayName("api 추가")
    void addApi() throws Exception {
        //given
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .apiType(ApiType.SHOPPING_API)
                .currentUsage(0)
                .maxUsage(30000)
                .build();
        ResponseEntity<ApiUsageDTO> responseEntity = ResponseEntity.ok(apiUsageDTO);
        String strEntity = objectMapper.writeValueAsString(responseEntity.getBody());
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/api")
                    .content(strEntity)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("api 사용량 증가")
    void increaseUsage() throws Exception {
        //given
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/current-usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("currentUsage").value(equalTo(1)));
    }

    @Test
    @DisplayName("api 사용량 초기화")
    void initUsage() throws Exception{
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/usage-zero"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}