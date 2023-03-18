package com.jung.service;

import com.jung.domain.user.ApprovalState;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        assertEquals(findUser.get(0).getUserId(),dto.getUserId());

    }

    @Test
    @DisplayName("로그인 테스트")
    void signIn() {
        //given
        //when
        ResponseEntity<?> responseEntity = userService.signIn(this.userDTO.getUserId(), this.userDTO.getUserPw());
        //than
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    void signInFail() {
        //given
        //when
        ResponseEntity<?> responseEntity = userService.signIn(this.userDTO.getUserId(), "abc");
        //than
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("승인처리 테스트")
    void approve() {
        //given
        userService.approveUser(this.userDTO.getUserId());
        //when
        List<User> user = userService.findUserById(this.userDTO.getUserId());
        //than
        assertEquals(user.get(0).getState(), ApprovalState.ACCEPTED);
    }
}