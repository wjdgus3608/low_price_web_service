package com.jung.service;

import com.jung.domain.comparecart.CartProduct;
import com.jung.domain.comparecart.CartUtil;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
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
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user2");
        //then
        assertTrue(searchedCart.isPresent());
        assertEquals("user2",searchedCart.get().getOwnerId());
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
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");
        //then
        assertFalse(searchedCart.isPresent());
    }


    @Test
    @DisplayName("비교카트 비우기")
    void clearCart() {
        //given
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");
        //when
        assertTrue(searchedCart.isPresent());
        compareCartService.clearCart(searchedCart.get().getOwnerId());
        //then
        assertEquals(0,searchedCart.get().getCartProducts().size());
    }

    @Test
    @DisplayName("비교카트 검색")
    void searchCart() {
        //given
        //when
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");
        //then
        assertTrue(searchedCart.isPresent());
        assertEquals("user1",searchedCart.get().getOwnerId());
    }

    @Test
    @DisplayName("비교카트 상품추가")
    void addProductToCart() {
        //given
        CartProduct cartProduct = CartUtil.generateCartProduct(1L,"user1");
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");
        //when
        compareCartService.addProductToCart(cartProduct);
        //then
        assertTrue(searchedCart.isPresent());
        assertEquals(1,searchedCart.get().getCartProducts().size());
        assertEquals(1L,searchedCart.get().getCartProducts().get(0).getProductId());
        assertEquals(searchedCart.get(),searchedCart.get().getCartProducts().get(0).getCompareCart());
    }

    @Test
    @DisplayName("비교카트 상품추가(중복)")
    void addProductToCartWithDup() {
        //given
        CartProduct cartProduct = CartUtil.generateCartProduct(1L,"user1");
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");
        //when
        compareCartService.addProductToCart(cartProduct).getStatusCode();
        //then
        assertEquals(HttpStatus.BAD_REQUEST,compareCartService.addProductToCart(cartProduct).getStatusCode());
        assertTrue(searchedCart.isPresent());
        assertEquals(1,searchedCart.get().getCartProducts().size());
    }

    @Test
    @DisplayName("비교카트 상품제거")
    void removeProductFromCart() {
        //given
        CartProduct cartProduct = CartUtil.generateCartProduct(1L,"user1");
        compareCartService.addProductToCart(cartProduct);
        Optional<CompareCart> searchedCart = compareCartService.searchCart("user1");

        //when
        ResponseEntity<?> responseEntity = compareCartService.removeProductFromCart(cartProduct);
        //then
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertTrue(searchedCart.isPresent());
        assertEquals(0,searchedCart.get().getCartProducts().size());
    }

    @Test
    @DisplayName("비교카트 상품제거(없는 상품제거시)")
    void removeNotInProductFromCart() {
        //given
        CartProduct cartProduct = CartUtil.generateCartProduct(3L,"user1");
        //when
        //then
        assertEquals(HttpStatus.BAD_REQUEST,compareCartService.removeProductFromCart(cartProduct).getStatusCode());
    }






}