package com.jung.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    @PostMapping("/user/auth")
    public ResponseEntity<?> signIn(@RequestBody String loginInfo) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(loginInfo);
        String userId = (String)obj.get("userId");
        String userPw = (String)obj.get("userPw");

        return userService.signIn(userId,userPw);
    }
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
