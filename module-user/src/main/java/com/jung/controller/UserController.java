package com.jung.controller;

import com.jung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public ResponseEntity<?> signUp(){
//
//    }
//
//    public ResponseEntity<?> signIn(){
//
//    }
//
//    public ResponseEntity<?> approve(){
//
//    }
//
//    public ResponseEntity<?> findUser(){
//
//    }
}
