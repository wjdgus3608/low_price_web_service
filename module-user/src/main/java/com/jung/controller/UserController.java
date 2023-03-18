package com.jung.controller;

import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/new-user")
    public ResponseEntity<?> signUp(@RequestBody @Valid UserDTO userDTO){
        return userService.signUp(userDTO);
    }
//
//    public ResponseEntity<?> signIn(){
//
//    }
//
//    public ResponseEntity<?> approve(){
//
//    }
//
    @PostMapping("/user")
    public ResponseEntity<?> findUser(@RequestBody String userId){
        List<User> user = userService.findUserById(userId);
        if(user.size()==0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(user.get(0));
    }
}
