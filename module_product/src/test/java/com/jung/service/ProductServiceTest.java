package com.jung.service;

import com.jung.domain.product.SearchInfo;
import com.jung.domain.product.SortType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private SearchInfo searchInfo;

    @BeforeAll
    void setSearchInfo(){
        searchInfo = SearchInfo.builder()
                .query("삼겹살")
                .display(100)
                .start(1)
                .sort(SortType.sim)
                .build();
    }
    @Test
    void searchProduct() {
        
    }
}