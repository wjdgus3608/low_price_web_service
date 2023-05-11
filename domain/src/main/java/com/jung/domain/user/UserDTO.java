package com.jung.domain.user;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int responseCode;
    private String responseMessage;
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
    @NotNull
    private String userName;
    private UserType userType;

    public User dtoToEntity(UserDTO userDTO){
        return User.builder()
                .userId(userDTO.getUserId())
                .userPw(userDTO.getUserPw())
                .userType(userDTO.getUserType())
                .userName(userDTO.getUserName())
                .state(ApprovalState.WAIT)
                .build();
    }
}
