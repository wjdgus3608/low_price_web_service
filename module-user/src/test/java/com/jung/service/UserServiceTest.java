package com.jung.service;

import com.jung.domain.user.ApprovalState;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        userService.signUp(this.userDTO);
    }

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        //given
        UserDTO dto = UserDTO.builder()
                .userId("user2")
                .userPw("pw2")
                .userName("Cane")
                .userType(UserType.USER)
                .build();
        userService.signUp(dto);
        //when
        List<User> findUser = userService.findUserById(dto.getUserId());
        //than
        assertEquals(dto.getUserId(),findUser.get(0).getUserId());

    }

    @Test
    @DisplayName("중복 ID 회원가입 테스트")
    void signUpWithDup() {
        //given
        UserDTO dto = UserDTO.builder()
                .userId("user1")
                .userPw("pw2")
                .userName("Cane")
                .userType(UserType.USER)
                .build();

        //when
        ResponseEntity<?> responseEntity = userService.signUp(dto);
        //than
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());

    }

    @Test
    @DisplayName("로그인 실패(비번 불일치) 테스트")
    void signInPwFail() {
        //given
        //when
        ResponseEntity<?> responseEntity = userService.signIn(this.userDTO.getUserId(), "abc");
        //than
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("로그인 실패(승인 안됨) 테스트")
    @Order(1)
    void signInApproveFail() {
        //given
        //when
        ResponseEntity<?> responseEntity = userService.signIn(this.userDTO.getUserId(), this.userDTO.getUserPw());
        //than
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    @Order(2)
    void signIn() {
        //given
        userService.approveUser(this.userDTO.getUserId());
        //when
        ResponseEntity<?> responseEntity = userService.signIn(this.userDTO.getUserId(), this.userDTO.getUserPw());
        //than
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("승인처리 테스트")
    @Order(3)
    void approve() {
        //given
        userService.approveUser(this.userDTO.getUserId());
        //when
        List<User> user = userService.findUserById(this.userDTO.getUserId());
        //than
        assertEquals(ApprovalState.ACCEPTED,user.get(0).getState());
    }
}