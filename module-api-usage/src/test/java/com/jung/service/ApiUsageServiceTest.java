package com.jung.service;

import com.jung.domain.apiusage.ApiUsageDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ApiUsageServiceTest {

    @Autowired
    private ApiUsageService apiUsageService;

    @Test
    @DisplayName("api 현재 사용량 조회")
    void getUsage() {
        //given
        //when
        ApiUsageDTO apiUsageDTO = apiUsageService.getUsage();
        //than
//        assertTrue(apiUsageDTO);
    }

    @Test
    @DisplayName("api 최대 사용량 조회")
    void getMaxUsage() {
        //given
        //when
        //than
    }

    @Test
    @DisplayName("api 사용량 증가")
    void increaseUsage() {
        //given
        //when
        //than
    }

    @Test
    @DisplayName("api 현재 사용량 초기화")
    void initUsage() {
        //given
        //when
        //than
    }
}