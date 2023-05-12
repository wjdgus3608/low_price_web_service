package com.jung.service;

import com.jung.domain.user.ApprovalState;
import com.jung.domain.user.User;
import com.jung.domain.user.UserDTO;
import com.jung.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> signUp(UserDTO userDTO){
        if(isDupId(userDTO.getUserId()))
            return ResponseEntity.badRequest().build();

        userRepository.save(userDTO.dtoToEntity(userDTO));
        return ResponseEntity.ok().build();
    }

    public boolean signIn(String userId, String userPw){

        if(!isIdAndPwCorrect(userId,userPw)){
            return false;
        }
        return isApproved(userId);
    }


    @Transactional
    public ResponseEntity<?> approveUser(String userId){
        Optional<User> user = findUserById(userId);
        user.ifPresent(User::approve);
        return ResponseEntity.ok().build();
    }

    public Optional<User> findUserById(String userId){
        return userRepository.findByUserId(userId);
    }

    private boolean isIdAndPwCorrect(String userId, String userPw){
        Optional<User> user = findUserById(userId);
        return user.filter((value)->value.getUserPw().equals(userPw)).isPresent();
    }

    private boolean isApproved(String userId){
        Optional<User> user = findUserById(userId);
        return user.filter(value -> value.getState() == ApprovalState.ACCEPTED).isPresent();
    }

    private boolean isDupId(String userId){
        return userRepository.findByUserId(userId).isPresent();
    }

}
