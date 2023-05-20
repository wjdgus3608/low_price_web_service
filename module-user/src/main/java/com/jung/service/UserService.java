package com.jung.service;

import com.jung.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;

    @Transactional
    public ResponseEntity<?> signUp(UserDTO userDTO){
        if(isDupId(userDTO.getUserId()))
            return ResponseEntity.badRequest().build();

        userRepository.save(userDTO.dtoToEntity(userDTO));
        return ResponseEntity.ok().build();
    }

    public Optional<String> signIn(String userId, String userPw){

        if(!isIdAndPwCorrect(userId,userPw) || !isApproved(userId)){
            return Optional.empty();
        }

        return Optional.of(generateUserSession());
    }

/*    public boolean signOut(String userId){
        userSessionRepository.delete();
    }*/


    @Transactional
    public ResponseEntity<?> approveUser(String userId){
        Optional<User> user = findUserById(userId);
        user.ifPresent(User::approve);
        return ResponseEntity.ok().build();
    }

    public Optional<User> findUserById(String userId){
        return userRepository.findByUserId(userId);
    }

    public Optional<UserSession> findUserSessionById(String userId){ return userSessionRepository.findById(userId); }

    private String generateUserSession(){
        return UUID.randomUUID().toString();
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
