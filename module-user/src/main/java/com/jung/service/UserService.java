package com.jung.service;

import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> signUp(UserDTO userDTO){
        userRepository.save(userDTO.dtoToEntity(userDTO));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> signIn(String userId, String userPw){
        List<User> user = findUserById(userId);
        if(user.size()!=0 && user.get(0).getUserPw().equals(userPw))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    @Transactional
    public ResponseEntity<?> approval(String userId){
        return ResponseEntity.ok().build();
    }

    public List<User> findUserById(String userId){
        return userRepository.findByUserId(userId);
    }
}
