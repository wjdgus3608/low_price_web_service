package com.jung.service;

import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> signUp(UserDTO userDTO){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> signIn(String userId, String userPw){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> approval(String userId){
        return ResponseEntity.ok().build();
    }

    public User findUserById(String userId){
        return null;
    }
}
