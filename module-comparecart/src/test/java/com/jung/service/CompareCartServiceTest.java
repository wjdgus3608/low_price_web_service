package com.jung.service;

import com.jung.domain.comparecart.CartProduct;
import com.jung.domain.comparecart.CompareCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class CompareCartServiceTest {

    @Autowired
    private CompareCartService compareCartService;

    @BeforeAll
    void setCompareCart(){
        compareCartService.generateCart("user1");
    }

    @Test
    @DisplayName("비교카트 생성")
    void generateCart() {
        //given
        compareCartService.generateCart("user2");
        //when
        CompareCart searchedCart = compareCartService.searchCart("user2");
        //then
        assertNotNull(searchedCart);
        assertEquals("user2",searchedCart.getOwnerId());
    }

    @Test
    @DisplayName("비교카트 중복 생성")
    void generateCartWithDup() {
        //given
        //when
        ResponseEntity<?> responseEntity = compareCartService.generateCart("user1");
        //then
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("비교카트 삭제")
    void removeCart() {
        //given
        compareCartService.removeCart("user1");
        //when
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //then
        assertNull(searchedCart);
    }

    @Test
    @DisplayName("없는 비교카트 삭제")
    void removeCartWithNotExists() {
        //given
        //when
        ResponseEntity<?> responseEntity = compareCartService.removeCart("user2");
        //then
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    void clearCart() {
    }

    @Test
    @DisplayName("비교카트 검색")
    void searchCart() {
        //given
        //when
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //then
        assertNotNull(searchedCart);
        assertEquals("user1",searchedCart.getOwnerId());
    }

    @Test
    @DisplayName("비교카트 상품추가")
    @Transactional
    void addProductToCart() {
        //given
        CartProduct cartProduct = CartProduct.builder()
                .productId(1L)
                .build();
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //when
        searchedCart.addProduct(cartProduct);
        //then
        assertEquals(1,searchedCart.getCartProducts().size());
        assertEquals(1L,searchedCart.getCartProducts().get(0).getProductId());
        assertEquals(searchedCart,searchedCart.getCartProducts().get(0).getCompareCart());
    }

    @Test
    void removeProductFromCart() {
    }


}