package com.jung.service;

import com.jung.domain.apiusage.ApiType;
import com.jung.domain.apiusage.ApiUsage;
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
        ApiUsage apiUsageDTO = apiUsageService.getApiInfo();
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
        ApiUsage apiUsageDTO = apiUsageService.getApiInfo();
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
        ApiUsage apiUsageDTO = apiUsageService.getApiInfo();
        //than
        assertEquals(0,apiUsageDTO.getCurrentUsage());
    }

    @Test
    @DisplayName("Redis 캐시 속도 테스트")
    void selectTest(){
        long start1 = System.currentTimeMillis();

        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());

        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();

        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());
        System.out.println(apiUsageService.getApiInfo());

        long end2 = System.currentTimeMillis();

        System.out.println(end2 - start2);
    }
}