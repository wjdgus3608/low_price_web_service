package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsageDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiUsageServiceTest {

    @Autowired
    private ApiUsageService apiUsageService;

    @BeforeAll
    void initApiUsage(){
        ApiUsageDTO apiUsageDTO = ApiUsageDTO.builder()
                .apiType(ApiType.SHOPPING_API)
                .currentUsage(0)
                .maxUsage(25000)
                .build();
        apiUsageService.addApi(apiUsageDTO);
    }

    @Test
    @DisplayName("api 조회")
    void getUsage() {
        //given
        //when
        ResponseEntity<?> responseEntity = apiUsageService.getApiInfo();
        ApiUsageDTO apiUsageDTO = (ApiUsageDTO) responseEntity.getBody();
        //than
        assertEquals(ApiType.SHOPPING_API,apiUsageDTO.getApiType());
        assertEquals(0,apiUsageDTO.getCurrentUsage());
        assertEquals(25000,apiUsageDTO.getMaxUsage());
    }


    @Test
    @DisplayName("api 사용량 증가")
    void increaseUsage() {
        //given
        apiUsageService.increaseUsage();
        //when
        ResponseEntity<?> responseEntity = apiUsageService.getApiInfo();
        ApiUsageDTO apiUsageDTO = (ApiUsageDTO) responseEntity.getBody();
        //than
        assertEquals(1,apiUsageDTO.getCurrentUsage());
    }


    @Test
    @DisplayName("api 현재 사용량 초기화")
    void initUsage() {
        //given
        apiUsageService.increaseUsage();
        apiUsageService.initUsage();
        //when
        ResponseEntity<?> responseEntity = apiUsageService.getApiInfo();
        ApiUsageDTO apiUsageDTO = (ApiUsageDTO) responseEntity.getBody();
        //than
        assertEquals(0,apiUsageDTO.getCurrentUsage());
    }
}