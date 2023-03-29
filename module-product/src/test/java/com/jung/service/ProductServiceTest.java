package com.jung.service;

import com.jung.domain.product.Product;
import com.jung.domain.product.SearchInfo;
import com.jung.domain.product.SortType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    @DisplayName("상품검색 테스트")
    void searchProduct() {
        //given

        //when
        List<Product> products = productService.searchProduct(searchInfo);
        //than
        assertEquals(100,products.size());
        assertEquals(true,products.get(0).getProductName().contains("삼겹살"));
    }

    @Test
    @DisplayName("상품검색 캐시 테스트")
    void searchTestWithRedis() {
        //given
        long start1 = System.currentTimeMillis();
        System.out.println(productService.searchProduct(searchInfo));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(productService.searchProduct(searchInfo));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }

}