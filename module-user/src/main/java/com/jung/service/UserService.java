package com.jung.service;

import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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

        if(isIdAndPwCorrect(userId,userPw)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @Transactional
    public ResponseEntity<?> approveUser(String userId){
        List<User> user = userRepository.findByUserId(userId);
        user.get(0).approve();
        return ResponseEntity.ok().build();
    }

    public List<User> findUserById(String userId){
        return userRepository.findByUserId(userId);
    }

    private boolean isIdAndPwCorrect(String userId, String userPw){
        List<User> user = findUserById(userId);
        return user.size() != 0 && user.get(0).getUserPw().equals(userPw);
    }

}
