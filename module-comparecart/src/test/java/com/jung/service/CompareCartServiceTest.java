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
    @DisplayName("비교카트 비우기")
    void clearCart() {
        //given
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //when
        compareCartService.clearCart(searchedCart.getOwnerId());
        //then
        assertEquals(0,searchedCart.getCartProducts().size());
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
    void addProductToCart() {
        //given
        CartProduct cartProduct = generateCartProduct(1L);
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //when
        compareCartService.addProductToCart(cartProduct);
        //then
        assertEquals(1,searchedCart.getCartProducts().size());
        assertEquals(1L,searchedCart.getCartProducts().get(0).getProductId());
        assertEquals(searchedCart,searchedCart.getCartProducts().get(0).getCompareCart());
    }

    @Test
    @DisplayName("비교카트 상품추가(중복)")
    void addProductToCartWithDup() {
        //given
        CartProduct cartProduct = generateCartProduct(1L);
        CompareCart searchedCart = compareCartService.searchCart("user1");
        //when
        compareCartService.addProductToCart(cartProduct);
//        ResponseEntity<?> responseEntity = compareCartService.addProductToCart(cartProduct);
        //then
//        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
//        assertEquals(1,searchedCart.getCartProducts().size());
    }

    @Test
    @DisplayName("비교카트 상품제거")
    void removeProductFromCart() {
        //given
        CartProduct cartProduct = generateCartProduct(1L);
        compareCartService.addProductToCart(cartProduct);
        CompareCart searchedCart = compareCartService.searchCart("user1");

        //when
        ResponseEntity<?> responseEntity = compareCartService.removeProductFromCart(cartProduct);
        //then
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(0,searchedCart.getCartProducts().size());
    }

    @Test
    @DisplayName("비교카트 상품제거(없는 상품제거시)")
    void removeNotInProductFromCart() {
        //given
        CartProduct cartProduct = generateCartProduct(1L);
        //when
        ResponseEntity<?> responseEntity = compareCartService.removeProductFromCart(cartProduct);
        //then
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    private CartProduct generateCartProduct(long id){
        return CartProduct.builder()
                .productId(id)
                .compareCart(compareCartService.searchCart("user1"))
                .build();
    }


}