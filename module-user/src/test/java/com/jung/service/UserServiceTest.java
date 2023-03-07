package com.jung.service;

import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
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
class UserServiceTest {
    @Autowired
    private UserService userService;

    private UserDTO userDTO;

    @BeforeAll
    void setDto(){
        this.userDTO = UserDTO.builder()
                .userId("user1")
                .userPw("pw1")
                .userName("John")
                .userType(UserType.USER)
                .build();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        //given
        userService.signUp(this.userDTO);
        //when
        List<User> findUser = userService.findUserById(this.userDTO.getUserId());
        //than
        assertEquals(findUser.get(0).getUserId(),this.userDTO.getUserId());

    }

    @Test
    @DisplayName("로그인 테스트")
    void signIn() {
    }

    @Test
    @DisplayName("승인처리 테스트")
    void approval() {
    }
}