package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsageDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .apiUsage(0)
                .maxUsage(25000)
                .build();
        apiUsageService.addApi(apiUsageDTO);
    }

    @Test
    @DisplayName("api 현재 사용량 조회")
    void getUsage() {
        //given
        //when
        ApiUsageDTO apiUsageDTO = apiUsageService.getUsage();
        //than
        assertEquals(0,apiUsageDTO.getApiUsage());
    }

    @Test
    @DisplayName("api 최대 사용량 조회")
    void getMaxUsage() {
        //given
        //when
        ApiUsageDTO apiUsageDTO = apiUsageService.getMaxUsage();
        //than
        assertEquals(25000,apiUsageDTO.getMaxUsage());

    }

    @Test
    @DisplayName("api 사용량 증가")
    void increaseUsage() {
        //given
        apiUsageService.increaseUsage();
        //when
        ApiUsageDTO apiUsageDTO = apiUsageService.getUsage();
        //than
        assertEquals(1,apiUsageDTO.getApiUsage());
    }

    @Test
    @DisplayName("api 현재 사용량 초기화")
    void initUsage() {
        //given
        apiUsageService.increaseUsage();
        ApiUsageDTO apiUsageDTO = apiUsageService.initUsage();
        //than
        assertEquals(0,apiUsageDTO.getApiUsage());
    }
}