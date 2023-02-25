package com.jung.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.service.ApiUsageService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@WebMvcTest(ApiUsageController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ApiUsageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
//
//    @MockBean

//    private ApiUsageService apiUsageService;
    private ResponseEntity<?> entity;

    ApiUsageControllerTest(){
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .currentUsage(0)
                .maxUsage(25000)
                .build();
        this.entity = ResponseEntity.ok(apiUsageDTO);
    }

    @BeforeAll
    void addTestApi() throws Exception {
//        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
//                .apiType(ApiType.SHOPPING_API)
//                .currentUsage(0)
//                .maxUsage(25000)
//                .build();
//        apiUsageService.addApi(apiUsageDTO);

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
//        doReturn(entity).when(apiUsageService).getUsage();
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/current-usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("currentUsage").value(equalTo(0)));
    }

/*    @Test
    @DisplayName("api 최대 사용량 조회")
    void getMaxUsage() throws Exception {
        //given
        doReturn(entity).when(apiUsageService).getMaxUsage();
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
        String strEntity = objectMapper.writeValueAsString(entity.getBody());
        doReturn(entity).when(apiUsageService).addApi((ApiUsageDTO) entity.getBody());
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
        doReturn(entity).when(apiUsageService).increaseUsage();
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/usage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("currentUsage").value(equalTo(0)))
                .andDo(print());
    }*/

    @Test
    void initUsage() {
    }
}