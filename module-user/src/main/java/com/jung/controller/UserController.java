package com.jung.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.jung.domain.apiusage.ApiUsageDTO;
import com.jung.domain.user.LoginDTO;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.service.UserService;
import com.jung.utils.RandomSessionIdGenerator;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private static final JSONParser parser = new JSONParser();

    @PostMapping("/new-user")
    public ResponseEntity<?> signUp(@RequestBody @Valid UserDTO userDTO){
        return userService.signUp(userDTO);
    }

    @PostMapping("/user/auth")
    public ResponseEntity<?> signIn(@RequestBody @Valid LoginDTO loginDTO, HttpSession session) {
        boolean isLoginSuccess = userService.signIn(loginDTO.getUserId(), loginDTO.getUserPw());
        if (isLoginSuccess && session.getAttribute("loginSession") == null){
            session.setAttribute("loginSession", RandomSessionIdGenerator.generateSessionId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/user/approval")
    public ResponseEntity<?> approve(@RequestBody String requestBody) throws ParseException {
        JSONObject obj = (JSONObject) parser.parse(requestBody);
        String userId = (String)obj.get("userId");
        return userService.approveUser(userId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findUser(@PathVariable String userId){
        List<User> user = userService.findUserById(userId);
        if(user.size()==0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(user.get(0));
    }
}
