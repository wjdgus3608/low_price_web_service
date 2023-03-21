package com.jung.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private UserDTO userDTO;

    @BeforeAll
    void init() throws Exception {
        this.userDTO = UserDTO.builder()
                .userId("user1")
                .userPw("pw1")
                .userName("John")
                .userType(UserType.USER)
                .build();
        String strEntity = objectMapper.writeValueAsString(this.userDTO);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/new-user")
                .content(strEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원가입 테스트")
    @Order(1)
    void signUp() throws Exception {
        //given
        UserDTO dto = UserDTO.builder()
                .userId("user2")
                .userPw("pw2")
                .userName("Mike")
                .userType(UserType.USER)
                .build();
        String strEntity = objectMapper.writeValueAsString(dto);
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/new-user")
                .content(strEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content("user1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("userId").value(equalTo("user1")))
                .andDo(print());
    }


    @Test
    @DisplayName("로그인 실패(비번틀림) 테스트")
    @Order(2)
    void signInWithWrong() throws Exception {
        //given
        ObjectNode obj = objectMapper.createObjectNode();
        obj.put("userId","user1");
        obj.put("userPw","pw333");
        String strEntity = objectMapper.writeValueAsString(obj);
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/user/auth")
                .content(strEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 실패(승인전) 테스트")
    @Order(3)
    void signInWithNotApprove() throws Exception {
        //given
        ObjectNode obj = objectMapper.createObjectNode();
        obj.put("userId","user1");
        obj.put("userPw","pw1");
        String strEntity = objectMapper.writeValueAsString(obj);
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/user/auth")
                .content(strEntity)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("승인처리 테스트")
    @Order(4)
    void approve() {
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    @Order(5)
    void signInSuccess() {

    }

}