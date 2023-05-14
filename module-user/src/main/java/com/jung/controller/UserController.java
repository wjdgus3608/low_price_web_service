package com.jung.controller;

import com.fasterxml.jackson.core.JsonParser;
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
import java.util.Optional;

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
        if (isLoginSuccess){
            if(session.getAttribute("loginUser") == null)
                session.setAttribute("loginUser", userService.findUserById(loginDTO.getUserId()));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/auth")
    public ResponseEntity<?> logOut(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("loginUser");
        if(user != null){
            httpSession.invalidate();
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
        Optional<User> user = userService.findUserById(userId);
        if(user.isEmpty())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(user.get());
    }
}
