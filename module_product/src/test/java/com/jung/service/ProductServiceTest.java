package com.jung.service;

import com.jung.domain.product.Product;
import com.jung.domain.product.SearchInfo;
import com.jung.domain.product.SortType;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
import org.junit.jupiter.api.BeforeAll;
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
    void searchProduct() {
        //given

        //when
        List<Product> products = searchInfo.searchProduct(searchInfo);
        //than
        assertEquals(100,products.size());
        assertEquals(true,products.get(0).getProductName().contains("삼겹살"));
    }
}